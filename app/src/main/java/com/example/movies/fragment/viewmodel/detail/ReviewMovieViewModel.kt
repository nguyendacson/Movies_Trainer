package com.example.movies.fragment.viewmodel.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.fragment.repository.detail.ReviewMovieRepository
import com.example.movies.fragment.ui.ErrorView
import com.example.movies.database.movie.ReviewMovieDetailData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ReviewMovieViewModel(private val reviewMovieRepository: ReviewMovieRepository) : ViewModel() {

    private val _reviewMovie = MutableStateFlow<List<ReviewMovieDetailData>>(emptyList())
    val reviewMovie: StateFlow<List<ReviewMovieDetailData>> = _reviewMovie.asStateFlow()

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    private val _errorReviewMovie = Channel<ErrorView>()
    val errorReviewMovie = _errorReviewMovie.receiveAsFlow()

    fun reviewMovie(idMovie: String) {
        viewModelScope.launch {
            try {
                reviewMovieRepository.reviewMovies(idMovie)
                    .collect { response ->
                        if (response.isNotEmpty()) {
                            _reviewMovie.value = response
                        } else {
                            _errorReviewMovie.send(ErrorView.DataError)
                        }
                    }
            } catch (e: Exception) {
                _errorReviewMovie.send(ErrorView.NetworkError)
            } finally {
                _loading.value = false
            }
        }
    }
}