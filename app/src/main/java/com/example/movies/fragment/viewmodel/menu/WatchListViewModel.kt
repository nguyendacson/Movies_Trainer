package com.example.movies.fragment.viewmodel.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.fragment.repository.menu.WatchListMovieRepository
import com.example.movies.database.movie.MovieData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class WatchListViewModel(private val watchListMovieRepository: WatchListMovieRepository) :
    ViewModel() {
    private val _watchListMovie = MutableStateFlow<List<MovieData>>(emptyList())
    val watchListMovie: StateFlow<List<MovieData>> = _watchListMovie

    init {
        fetchMovies()
    }

    fun refresh(){
        fetchMovies()
    }
    private fun fetchMovies() {
        viewModelScope.launch {
            watchListMovieRepository.getWatchListMovie().collectLatest { response ->
                _watchListMovie.value = response
            }
        }
    }
}