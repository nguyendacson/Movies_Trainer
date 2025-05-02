package com.example.movies.fragment.repository.detail

import android.app.Application
import com.example.movies.R
import com.example.movies.api.ApiMovie
import com.example.movies.database.movie.CastMovieDetailData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CastMovieRepository(
    private val apiMovie: ApiMovie, application: Application
) {
    private val appContext = application.applicationContext
    fun castMovies(query: String): Flow<List<CastMovieDetailData>> = flow {
        try {
            val response = apiMovie.getCastMovieDetail(query)
            if (response.isSuccessful) {
                emit(response.body()?.cast ?: emptyList())
            } else {
                println(appContext.getString(R.string.Fails, "API"))
                emit(emptyList())
            }
        } catch (e: Exception) {
            println("${appContext.getString(R.string.Fails, "API")}: ${e.message}")
            emit(emptyList())
        }
    }
}