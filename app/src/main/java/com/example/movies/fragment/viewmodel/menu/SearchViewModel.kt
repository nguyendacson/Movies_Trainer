package com.example.movies.fragment.viewmodel.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.fragment.repository.menu.SearchMovieRepository
import com.example.movies.database.movie.MovieData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(private val searchMovieRepository: SearchMovieRepository) : ViewModel() {

    private val _searchMovies = MutableStateFlow<List<MovieData>?>(emptyList())
    val searchMovies: StateFlow<List<MovieData>?> = _searchMovies.asStateFlow()

    fun searchMovies(nameMovie: String) {
        viewModelScope.launch {
            searchMovieRepository.searchMovies(nameMovie)
                .collect { response ->
                    _searchMovies.value = response
                }
        }
    }
}
