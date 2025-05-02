package com.example.movies.fragment.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies.R
import com.example.movies.adapter.movie.AdapterMovie
import com.example.movies.api.ApiMovie
import com.example.movies.database.movie.MovieData
import com.example.movies.database.movie.SortDirection
import com.example.movies.database.movie.SortField
import com.example.movies.databinding.FragmentAllMovieNowPlayBinding
import com.example.movies.fragment.factory.menu.HomeFactory
import com.example.movies.fragment.repository.menu.HomeMovieRepository
import com.example.movies.fragment.viewmodel.FilterViewModel
import com.example.movies.fragment.viewmodel.menu.HomeViewModel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class AllMovieNowPlayFragment : Fragment() {
    private lateinit var binding: FragmentAllMovieNowPlayBinding
    private var allMovieNowPlayAdapter: AdapterMovie? = null
    private val filterViewModel: FilterViewModel by activityViewModels()

    private val viewModel: HomeViewModel by viewModels {
        val application = requireActivity().application
        val response = HomeMovieRepository(ApiMovie.instance)
        HomeFactory(response, application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllMovieNowPlayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        allMovieNowPlayAdapter = AdapterMovie(requireContext())

        binding.recyclerAllNowPlay.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = allMovieNowPlayAdapter
        }

        binding.btnBackNowPlay.setOnClickListener {
            findNavController().navigate(R.id.action_allMovieNowPlayFragment_to_navGraphFragment)
        }

        binding.btnFilterNowPlay.setOnClickListener {
            val action = AllMovieNowPlayFragmentDirections
                .actionAllMovieNowPlayFragmentToFilterFragment("Now Play Filter")
            findNavController().navigate(action)
        }
        observeAndSortAllPlay(viewModel, filterViewModel)
    }

    private fun observeAndSortAllPlay(
        allMovieNowPLayViewModel: HomeViewModel,
        filterViewModel: FilterViewModel
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            combine(
                allMovieNowPLayViewModel.nowAllPlayingMovie,
                filterViewModel.sortState
            ) { allMovieNowPlayList, sortState ->
                val mappedList = allMovieNowPlayList.sortedByDescending { it.name?.lowercase() }
                val sortList = when (sortState.field) {
                    SortField.EVALUATE -> {
                        if (sortState.direction == SortDirection.ASCENDING)
                            mappedList.sortedBy { it.vote_average }
                        else
                            mappedList.sortedByDescending { it.vote_average }
                    }

                    SortField.YEAR -> {
                        if (sortState.direction == SortDirection.ASCENDING)
                            mappedList.sortedBy { it.first_air_date?.toIntOrNull() ?: 0 }
                        else
                            mappedList.sortedByDescending { it.first_air_date?.toIntOrNull() ?: 0 }
                    }

                    SortField.VOTE_COUNT -> {
                        if (sortState.direction == SortDirection.ASCENDING)
                            mappedList.sortedBy { it.vote_count }
                        else
                            mappedList.sortedByDescending { it.vote_count }
                    }

                    else -> mappedList
                }
                sortList
            }.collect { sortedList ->
                allMovieNowPlayAdapter?.submitList(sortedList)
                onClickIem()
            }
        }
    }

    private fun sentDataDetail(data: MovieData) {
        val bundle = Bundle().apply {
            putParcelable("movie", data)
        }
        findNavController().navigate(R.id.action_allMovieNowPlayFragment_to_detailFragment, bundle)
    }

    private fun onClickIem() {
        allMovieNowPlayAdapter?.onClick = { movie ->
            sentDataDetail(movie)
        }
    }
}