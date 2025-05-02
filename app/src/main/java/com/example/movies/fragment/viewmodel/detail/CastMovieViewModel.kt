package com.example.movies.fragment.viewmodel.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.fragment.repository.detail.CastMovieRepository
import com.example.movies.fragment.ui.ErrorView
import com.example.movies.database.movie.CastMovieDetailData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.io.IOException

class CastMovieViewModel(private val castMovieRepository: CastMovieRepository) : ViewModel() {

    private val _castMovie = MutableStateFlow<List<CastMovieDetailData>>(emptyList())
    val castMovie: StateFlow<List<CastMovieDetailData>> = _castMovie.asStateFlow()

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    private val _errorCastMovie = Channel<ErrorView>()
    val errorCastMovie = _errorCastMovie.receiveAsFlow()

    fun castMovies(idMovie: String) {
        viewModelScope.launch {
            try {
                castMovieRepository.castMovies(idMovie)
                    .collect { response ->
                        if (response.isNotEmpty()) {
                            _castMovie.value = response
                        } else {
                            _errorCastMovie.send(ErrorView.DataError)
                        }
                    }
            } catch (e: IOException) {
                _errorCastMovie.send(ErrorView.NetworkError)
            } finally {
                _loading.value = false
            }
        }
    }

}
