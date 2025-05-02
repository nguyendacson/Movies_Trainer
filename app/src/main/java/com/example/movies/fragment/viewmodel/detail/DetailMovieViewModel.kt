package com.example.movies.fragment.viewmodel.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.fragment.repository.detail.DetailMovieRepository
import com.example.movies.fragment.ui.ErrorView
import com.example.movies.database.movie.DetailResponse
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class DetailMovieViewModel(private val detailMovieRepository: DetailMovieRepository) : ViewModel() {

    private val _detailMovie = MutableStateFlow<DetailResponse?>(null)
    val detailMovie: StateFlow<DetailResponse?> = _detailMovie.asStateFlow()

    private val _errorDetail = Channel<ErrorView>()
    val errorDetailMovie = _errorDetail.receiveAsFlow()

    private val _errorPostMovie = Channel<ErrorView>()
    val errorPostMovie = _errorPostMovie.receiveAsFlow()

    fun detailMovie(idMovie: String) {
        viewModelScope.launch {
            try {
                detailMovieRepository.getDetails(idMovie)
                    .collect { response ->
                        _detailMovie.value = response
                    }
            } catch (e: Exception) {
                _errorDetail.send(ErrorView.NetworkError)
            }
        }
    }

    fun postListMovie(id: Int, save: Boolean) {
        viewModelScope.launch {
            try {
                val response = detailMovieRepository.postToWatchlist(id, save)
                if (response == null) {
                    _errorPostMovie.send(ErrorView.DataError)
                }
            } catch (e: Exception) {
                _errorPostMovie.send(ErrorView.NetworkError)
            }
        }
    }
}











