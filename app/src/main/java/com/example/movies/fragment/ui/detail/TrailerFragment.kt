package com.example.movies.fragment.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.movies.api.ApiMovie
import com.example.movies.databinding.FragmentTrailerBinding
import com.example.movies.fragment.factory.detail.TrailerFactory
import com.example.movies.fragment.repository.detail.TrailerMovieRepository
import com.example.movies.fragment.viewmodel.detail.TrailerMovieViewModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import kotlinx.coroutines.launch

@Suppress("DEPRECATION")
class TrailerFragment : Fragment() {
    private lateinit var binding: FragmentTrailerBinding
    private var movieTrailer: List<String>? = null
    private var isFullScreen = false
    private lateinit var youTubePlayer: YouTubePlayer
    private val viewModel: TrailerMovieViewModel by viewModels {
        val application = requireActivity().application
        val repository = TrailerMovieRepository(ApiMovie.instance, application)
        TrailerFactory(repository, application)
    }

    private val onBackPressedCallBack = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (isFullScreen) {
                youTubePlayer.toggleFullscreen()
            } else {
                remove()
                requireActivity().onBackPressed()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrailerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            onBackPressedCallBack
        )

        val movieId = arguments?.getString("data")

        if (movieId != null) {
            viewModel.trailerMovies(movieId)
        }

        val fullScreenContainer = binding.fullScreen
        lifecycle.addObserver(binding.trailerYoutubePlayer)

        binding.trailerYoutubePlayer.addFullscreenListener(object : FullscreenListener {
            override fun onEnterFullscreen(fullscreenView: View, exitFullscreen: () -> Unit) {
                isFullScreen = true
                fullScreenContainer.visibility = View.VISIBLE
                fullScreenContainer.addView(fullscreenView)

                val window = requireActivity().window
                WindowInsetsControllerCompat(window, binding.root).apply {
                    hide(WindowInsetsCompat.Type.systemBars())
                    systemBarsBehavior =
                        WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }

                requireActivity().requestedOrientation =
                    android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

            }

            override fun onExitFullscreen() {
                isFullScreen = false
                val window = requireActivity().window
                WindowInsetsControllerCompat(window, binding.root).apply {
                    show(WindowInsetsCompat.Type.systemBars())
                }
                binding.fullScreen.visibility = View.GONE
                binding.fullScreen.removeAllViews()

                requireActivity().requestedOrientation =
                    android.content.pm.ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
            }
        })


        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.trailerMovie.collect { trailer ->
                movieTrailer = trailer.map { it.key }
                actionTrailer(movieTrailer!!.toMutableList())
            }
        }
    }

    private fun actionTrailer(keys: MutableList<String>) {
        if (keys.isEmpty()) {
            println("keyMovie null")
            return
        }

        val key = keys.removeAt(0)
        val options = IFramePlayerOptions.Builder()
            .controls(1)
            .rel(0)
            .modestBranding(1)
            .ivLoadPolicy(3)
            .fullscreen(1)
            .build()

        val youTubePlayerView = binding.trailerYoutubePlayer
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.initialize(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                this@TrailerFragment.youTubePlayer = youTubePlayer
                youTubePlayer.loadVideo(key, 0f)
            }

            override fun onError(youTubePlayer: YouTubePlayer, error: PlayerConstants.PlayerError) {
                Toast.makeText(
                    requireContext(),
                    "Error playing video: $key, redirecting ...",
                    Toast.LENGTH_LONG
                ).show()
                actionTrailer(keys)
            }
        }, options)
    }
}
