package com.example.movies.fragment.repository.menu

import android.app.Application
import android.util.Log
import com.example.movies.R
import com.example.movies.api.ApiMovie
import com.example.movies.database.movie.MovieCategory
import com.example.movies.database.movie.MovieData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WatchListMovieRepository(private val apiMovie: ApiMovie, application: Application) {

    private val appContext = application.applicationContext
    fun getWatchListMovie(): Flow<List<MovieData>> = flow {
        try {
            val response = apiMovie.getWatchListMovie()
            if (response.isSuccessful) {
                emit(response.body()?.results?.sortedByDescending { it.popularity }?.map { movie ->
                    movie.copy(
                        category = movie.category ?: MovieCategory.WATCHLIST
                    )
                } ?: emptyList())

            } else {
                Log.e("WatchListRepository", ": ${response.code()} - ${response.message()}")
                emit(emptyList())
            }
        } catch (e: Exception) {
            Log.e("WatchListRepository", appContext.getString(R.string.Fails, "apiWatchList"))
            emit(emptyList())
        }
    }
}