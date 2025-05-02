package com.example.movies.fragment.ui.menu

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.R
import com.example.movies.adapter.movie.AdapterMovie
import com.example.movies.api.ApiMovie
import com.example.movies.database.movie.MovieData
import com.example.movies.databinding.FragmentHomeBinding
import com.example.movies.fragment.factory.menu.HomeFactory
import com.example.movies.fragment.repository.menu.HomeMovieRepository
import com.example.movies.fragment.viewmodel.menu.HomeViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var topRatedAdapter: AdapterMovie? = null
    private var nowPlayingAdapter: AdapterMovie? = null
    private var trendingAdapter: AdapterMovie? = null

    private val viewModel: HomeViewModel by viewModels {
        val application = requireActivity().application
        val response = HomeMovieRepository(ApiMovie.instance)
        HomeFactory(response, application)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        observeLoading(viewModel)

        collectLatestFlow(viewModel.topRateMovies) {
            topRatedAdapter?.submitList(it)
        }

        collectLatestFlow(viewModel.nowPlayingMovie) {
            nowPlayingAdapter?.submitList(it)
        }

        collectLatestFlow(viewModel.trendingMovie) {
            trendingAdapter?.submitList(it)
        }


        binding.btnSearchHome.setOnClickListener {
            val parentFragment = requireParentFragment() as NavGraphFragment
            parentFragment.switchToSearchTab()
        }

        binding.tvViewAllNowPlay.setOnClickListener {
            findNavController().navigate(R.id.action_navGraphFragment_to_allMovieNowPlayFragment)
        }

        binding.tvViewAllTrending.setOnClickListener {
            findNavController().navigate(R.id.action_navGraphFragment_to_allMovieTrendingFragment)
        }
        onClickItem()
    }

    private fun onClickItem() {
        topRatedAdapter?.onClick = { movie ->
            sentDataNavGraph(movie)
        }

        nowPlayingAdapter?.onClick = { movie ->
            sentDataNavGraph(movie)
        }

        trendingAdapter?.onClick = { movie ->
            sentDataNavGraph(movie)
        }
    }

    private fun sentDataNavGraph(data: MovieData) {
        val bundle = Bundle().apply {
            putParcelable("movie", data)
        }
        requireActivity().supportFragmentManager.setFragmentResult("keyMovie", bundle)
    }

    private fun setupView() {
        topRatedAdapter = AdapterMovie(requireContext())
        binding.recyclerViewMovieTop.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = topRatedAdapter
        }

        nowPlayingAdapter = AdapterMovie(requireContext())
        binding.recyclerViewNowPlay.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = nowPlayingAdapter
        }

        trendingAdapter = AdapterMovie(requireContext())
        binding.recyclerViewTrending.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = trendingAdapter
        }
    }

    private fun <T> collectLatestFlow(
        flow: StateFlow<T>,
        action: suspend (T) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collectLatest { action(it) }
            }
        }
    }

    private fun observeLoading(viewModel: HomeViewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loading.collect { isLoading ->
                binding.loadingHome.isVisible = isLoading
            }
        }
    }
}
