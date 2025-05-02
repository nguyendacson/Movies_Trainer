package com.example.movies.fragment.viewmodel.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.fragment.repository.detail.TrailerMovieRepository
import com.example.movies.fragment.ui.ErrorView
import com.example.movies.database.movie.Trailer
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TrailerMovieViewModel(private val trailerMovieRepository: TrailerMovieRepository) :
    ViewModel() {

    private val _trailerMovie = MutableStateFlow<List<Trailer>>(emptyList())
    val trailerMovie: StateFlow<List<Trailer>> = _trailerMovie.asStateFlow()


    private val _errorTrailerMovie = Channel<ErrorView>()
    val errorTrailerMovie = _errorTrailerMovie

    fun trailerMovies(idMovie: String) {
        viewModelScope.launch {
            try {
                trailerMovieRepository.trailerMovies(idMovie)
                    .collect { response ->
                        if (response.isNotEmpty()) {
                            _trailerMovie.value = response
                        } else {
                            _errorTrailerMovie.send(ErrorView.DataError)
                        }
                    }
            } catch (e: Exception) {
                _errorTrailerMovie.send(ErrorView.NetworkError)
            }
        }
    }
}