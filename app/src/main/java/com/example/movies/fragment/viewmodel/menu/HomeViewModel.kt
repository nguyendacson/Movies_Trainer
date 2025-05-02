package com.example.movies.fragment.viewmodel.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.database.movie.MovieData
import com.example.movies.fragment.repository.menu.HomeMovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val movieRepository: HomeMovieRepository) : ViewModel() {
    private val _topRateMovies = MutableStateFlow<List<MovieData>>(emptyList())
    val topRateMovies: StateFlow<List<MovieData>> = _topRateMovies.asStateFlow()

    private val _nowPlayingMovies = MutableStateFlow<List<MovieData>>(emptyList())
    val nowPlayingMovie: StateFlow<List<MovieData>> = _nowPlayingMovies.asStateFlow()

    private val _nowAllPlayingMovies = MutableStateFlow<List<MovieData>>(emptyList())
    val nowAllPlayingMovie: StateFlow<List<MovieData>> = _nowAllPlayingMovies.asStateFlow()

    private val _allTrendingMovies = MutableStateFlow<List<MovieData>>(emptyList())
    val allTrendingMovie: StateFlow<List<MovieData>> = _allTrendingMovies.asStateFlow()

    private val _trendingMovies = MutableStateFlow<List<MovieData>>(emptyList())
    val trendingMovie: StateFlow<List<MovieData>> = _trendingMovies.asStateFlow()

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            _loading.value = true

            val jobs = listOf(
                launch {
                    movieRepository.getTopRatedMovies().collect { _topRateMovies.value = it }
                },
                launch {
                    movieRepository.getNowPlayMovies().collect { _nowPlayingMovies.value = it }
                },
                launch {
                    movieRepository.getAllNowPlayMovies()
                        .collect { _nowAllPlayingMovies.value = it }
                },
                launch {
                    movieRepository.getTrendingMovies().collect { _trendingMovies.value = it }
                },
                launch {
                    movieRepository.getAllTrendingMovies().collect { _allTrendingMovies.value = it }
                }
            )
            jobs.forEach { it.join() }

            _loading.value = false
        }
//        viewModelScope.launch {
//            combine(
//                movieRepository.getTopRatedMovies(),
//                movieRepository.getNowPlayMovies(),
//                movieRepository.getAllNowPlayMovies(),
//                movieRepository.getTrendingMovies(),
//                movieRepository.getAllTrendingMovies()
//            ) { top, now, nowAll, trend, trendAll ->
//                listOf(top, now, nowAll, trend, trendAll)
//            }.collect { (top, now, nowAll, trend, trendAll) ->
//                _topRateMovies.value = top
//                _nowPlayingMovies.value = now
//                _nowAllPlayingMovies.value = nowAll
//                _trendingMovies.value = trend
//                _allTrendingMovies.value = trendAll
//
//                if (_loading.value) _loading.value = false
//            }
//        }
    }
}