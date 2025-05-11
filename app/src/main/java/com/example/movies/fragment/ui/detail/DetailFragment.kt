package com.example.movies.fragment.ui.detail

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.view.animation.TranslateAnimation
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.api.ApiMovie
import com.example.movies.database.movie.MovieData
import com.example.movies.databinding.FragmentDetailBinding
import com.example.movies.fragment.factory.detail.DetailFactory
import com.example.movies.fragment.repository.detail.DetailMovieRepository
import com.example.movies.fragment.ui.ErrorView
import com.example.movies.fragment.ui.toImageUrl
import com.example.movies.fragment.viewmodel.detail.DetailMovieViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {
    private var detailBinding: FragmentDetailBinding? = null
    private val binding get() = detailBinding!!
    private var selectedTab = 1
    private val args: DetailFragmentArgs by navArgs()
    private var movieDetail: MovieData? = null
    private var timeRun: String = ""
    private var saveList: Boolean = false

    private val viewModel: DetailMovieViewModel by viewModels {
        val application = requireActivity().application
        val repository = DetailMovieRepository(ApiMovie.instance, application)
        DetailFactory(repository, application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("DefaultLocale", "Recycle")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieDetail = args.movie
        viewModel.detailMovie(movieDetail?.id!!)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.detailMovie.collect { detail ->
                if (detail != null) {
                    timeRun = "${detail.runtime} minutes"
                    saveList = detail.account_states?.watchlist!!
                } else {
                    println("Data Detail Null")
                }
                setView()
                updateSaveButton()
            }
        }

        observeErrorDetail(viewModel)
        animation()

        binding.btnTrailer.setOnClickListener {
            val bundle = Bundle().apply {
                putString("data", movieDetail?.id)
            }
            findNavController().navigate(R.id.action_detailFragment_to_trailerFragment, bundle)
        }

        binding.saveMovie.setOnClickListener {
            onClickSave()
        }

        fun createAnimation(): TranslateAnimation {
            return TranslateAnimation(
                -500f, 0f, 0f, 0f
            ).apply {
                duration = 200
                fillAfter = true
            }
        }

        binding.tvAbout.post {
            binding.tvAbout.performClick()
        }

        binding.btnBackDetail.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.tvAbout.setOnClickListener {
            val aboutMovie = AboutMovieFragment()
            replaceView(aboutMovie, movieDetail?.overview.toString())
            setSelectedTab(
                1,
                binding.tvAbout,
                binding.tvReviews,
                binding.tvCast,
                binding.viewAbout,
                binding.viewReview,
                binding.viewCast
            )
            binding.viewAbout.startAnimation(createAnimation())
        }

        binding.tvReviews.setOnClickListener {
            val reviewMovieFragment = ReviewMovieFragment()
            replaceView(reviewMovieFragment, movieDetail?.id.toString())
            setSelectedTab(
                2,
                binding.tvReviews,
                binding.tvAbout,
                binding.tvCast,
                binding.viewReview,
                binding.viewAbout,
                binding.viewCast
            )
            binding.viewReview.startAnimation(createAnimation())
        }

        binding.tvCast.setOnClickListener {
            val castMovieFragment = CastMovieFragment()
            replaceView(castMovieFragment, movieDetail?.id.toString())
            setSelectedTab(
                3,
                binding.tvCast,
                binding.tvReviews,
                binding.tvAbout,
                binding.viewCast,
                binding.viewReview,
                binding.viewAbout
            )
            binding.viewCast.startAnimation(createAnimation())
        }

    }

    private fun animation() {
        binding.btnTrailer.translationY = 50f
        binding.btnTrailer.alpha = 0f
        binding.btnTrailer.visibility = View.VISIBLE

        val translation = ObjectAnimator.ofFloat(binding.btnTrailer, View.TRANSLATION_Y, 50f, 0f)
        val fadeIn = ObjectAnimator.ofFloat(binding.btnTrailer, View.ALPHA, 0f, 1f)

        translation.interpolator = DecelerateInterpolator()
        translation.duration = 500
        fadeIn.duration = 500

        translation.start()
        fadeIn.start()
    }

    private fun setView() {
        Glide.with(binding.itemImage.context)
            .load(movieDetail?.poster_path.toImageUrl())
            .into(binding.itemImage)
        Glide.with(requireContext())
            .load(movieDetail?.backdrop_path?.toImageUrl())
            .error(R.drawable.img_waiting).into(binding.itemBackDrop)
        binding.numberStarDetail.text =
            String.format(getString(R.string.convert_data), movieDetail?.vote_average)
        binding.nameMovie.text = movieDetail?.original_title

        binding.tvCalendarDetail.text =
            formatTextOrDefault(movieDetail?.release_date, { it.substring(0, 4) })

        binding.tvMinutesDetail.text = formatTextOrDefault(timeRun)

    }

    private fun formatTextOrDefault(
        value: String?,
        transform: (String) -> String = { it },
        defaultText: String = getString(R.string.null_data)
    ): String {
        return if (!value.isNullOrBlank()) transform(value) else defaultText
    }

    private fun updateSaveButton() {
        if (saveList) {
            binding.saveMovie.setImageResource(R.drawable.btn_after_favourite)
        } else {
            binding.saveMovie.setImageResource(R.drawable.btn_watchlist)
        }
    }

    private fun onClickSave() {
        val message = "movie ${movieDetail?.title} to hit list"
        saveList = !saveList
        if (saveList) {
            binding.saveMovie.setImageResource(R.drawable.btn_after_favourite)
            Toast.makeText(
                requireContext(), "Add $message", Toast.LENGTH_LONG
            ).show()
        } else {
            binding.saveMovie.setImageResource(R.drawable.btn_watchlist)
            Toast.makeText(
                requireContext(),
                "Delete $message",
                Toast.LENGTH_LONG
            ).show()
        }
        viewModel.postListMovie(movieDetail?.id!!.toInt(), saveList)
        observeErrorSave(viewModel)
    }

    private fun replaceView(view: Fragment, data: String) {
        val bundle = Bundle().apply {
            putString("data", data)
        }
        view.arguments = bundle
        childFragmentManager.beginTransaction().replace(R.id.viewPageDetail, view).commit()
    }

    private fun setSelectedTab(
        tabIndex: Int,
        selectedTextView: TextView,
        unselectedTextView1: TextView,
        unselectedTextView2: TextView,
        selectedView: View,
        unselectedView1: View,
        unselectedView2: View
    ) {
        selectedTab = tabIndex
        selectedTextView.setTextColor(Color.WHITE)
        unselectedTextView1.setTextColor(
            ContextCompat.getColor(
                requireContext(), R.color.menuBeforeDetail
            )
        )

        unselectedTextView2.setTextColor(
            ContextCompat.getColor(
                requireContext(), R.color.menuBeforeDetail
            )
        )

        selectedView.visibility = View.VISIBLE
        unselectedView1.visibility = View.GONE
        unselectedView2.visibility = View.GONE
    }

    private fun collectError(channel: Flow<ErrorView>, label: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            channel.collect { error ->
                val message = when (error) {
                    is ErrorView.DataError -> getString(R.string.Fails, label)
                    is ErrorView.NetworkError -> getString(R.string.Fails, "Connect Network")
                }
                Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun observeErrorDetail(viewModel: DetailMovieViewModel) {
        collectError(viewModel.errorDetailMovie, "Data")
    }

    private fun observeErrorSave(viewModel: DetailMovieViewModel) {
        collectError(viewModel.errorPostMovie, "Data Movie")
    }
}
