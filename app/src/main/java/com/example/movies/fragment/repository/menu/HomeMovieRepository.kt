package com.example.movies.fragment.repository.menu

import com.example.movies.api.ApiMovie
import com.example.movies.database.movie.MovieCategory
import com.example.movies.database.movie.MovieData
import com.example.movies.database.movie.MovieResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response


class HomeMovieRepository(private val apiMovie: ApiMovie) {

    fun getTopRatedMovies(): Flow<List<MovieData>> {
        return fetchMovies({ apiMovie.getMoviesTopRated() }, MovieCategory.TOP_RATED)
    }

    fun getNowPlayMovies(): Flow<List<MovieData>> {
        return fetchMovies({ apiMovie.getMoviesNowPlaying() }, MovieCategory.NOW_PLAYING)
    }

    fun getAllNowPlayMovies(): Flow<List<MovieData>> {
        return fetchAllMovies({ apiMovie.getMoviesNowPlaying() }, MovieCategory.ALL_NOW_PLAYING)
    }

    fun getTrendingMovies(): Flow<List<MovieData>> {
        return fetchMovies({ apiMovie.getMoviesTrending() }, MovieCategory.TRENDING)
    }

    fun getAllTrendingMovies(): Flow<List<MovieData>> {
        return fetchAllMovies({ apiMovie.getMoviesTrending() }, MovieCategory.ALL_TRENDING)
    }

    private fun fetchMovies(
        apiCall: suspend () -> Response<MovieResponse>, category: MovieCategory
    ): Flow<List<MovieData>> = flow {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                emit(response.body()?.results?.take(10)?.map { it.copy(category = category) }!!)
            } else {
                val errorMsg = response.errorBody()?.string() ?: "Unknown error"
                println("API Error: $errorMsg")

            }
        } catch (e: Exception) {
            println("Network Error: ${e.message}")
        }
    }

    private fun fetchAllMovies(
        apiCall: suspend () -> Response<MovieResponse>, category: MovieCategory
    ): Flow<List<MovieData>> = flow {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                emit(response.body()?.results?.map { it.copy(category = category) }!!)
            } else {
                val errorMsg = response.errorBody()?.string() ?: "Unknown error"
                println("API Error: $errorMsg")
            }
        } catch (e: Exception) {
            println("Network Error: ${e.message}")
        }
    }
}
