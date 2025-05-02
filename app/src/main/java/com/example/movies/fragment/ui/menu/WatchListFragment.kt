package com.example.movies.fragment.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.movies.adapter.movie.AdapterMovie
import com.example.movies.api.ApiMovie
import com.example.movies.database.movie.MovieCategory
import com.example.movies.database.movie.MovieData
import com.example.movies.databinding.FragmentWatchlistBinding
import com.example.movies.fragment.factory.menu.WatchListFactory
import com.example.movies.fragment.repository.menu.WatchListMovieRepository
import com.example.movies.fragment.viewmodel.menu.WatchListViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.LocalDate

class WatchListFragment : Fragment() {
    private var watchListBinding: FragmentWatchlistBinding? = null
    private val binding get() = watchListBinding!!
    private var watchListAdapter: AdapterMovie? = null

    private val viewModel: WatchListViewModel by viewModels {
        val application = requireActivity().application
        val repository = WatchListMovieRepository(ApiMovie.instance, application)
        WatchListFactory(repository, application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        watchListBinding = FragmentWatchlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.watchListMovie.collectLatest { movies ->
                val updatedMovies = movies.map {
                    it.copy(
                        first_air_date = it.first_air_date ?: LocalDate.now().year.toString(),
                        category = MovieCategory.WATCHLIST
                    )
                }

                watchListAdapter?.submitList(updatedMovies)
                if (watchListAdapter == null) {
                    binding.hintConstraint.visibility = View.VISIBLE
                } else {
                    binding.hintConstraint.visibility = View.GONE
                }
                binding.refreshLayout.isRefreshing = false
            }
        }

        if (watchListAdapter == null) {
            watchListAdapter = AdapterMovie(requireContext())
        }
        binding.mainItemList.setHasFixedSize(true)

        binding.mainItemList.adapter = watchListAdapter

        onClickItem()

        binding.refreshLayout.setOnRefreshListener {
            viewModel.refresh()
            binding.refreshLayout.postDelayed({
                binding.refreshLayout.isRefreshing = false
            }, 2000)
        }

    }

    private fun onClickItem() {
        println("Dã click")
        watchListAdapter?.onClick = { movie ->
            sentDataNavGraph(movie)
        }
    }

    private fun sentDataNavGraph(data: MovieData) {
        val bundle = Bundle().apply {
            putParcelable("movie", data)
        }
        requireActivity().supportFragmentManager.setFragmentResult("keyMovie", bundle)
    }
}