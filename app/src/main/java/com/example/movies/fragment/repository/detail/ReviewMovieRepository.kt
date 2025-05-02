package com.example.movies.fragment.repository.detail

import android.app.Application
import com.example.movies.R
import com.example.movies.api.ApiMovie
import com.example.movies.database.movie.ReviewMovieDetailData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ReviewMovieRepository(private val apiMovie: ApiMovie, application: Application) {
    private val appContext = application.applicationContext

    fun reviewMovies(query: String): Flow<List<ReviewMovieDetailData>> = flow {
        try {
            val response = apiMovie.getReviewMovieDetail(query)
            if (response.isSuccessful && response.body()?.results != null) {
                emit(response.body()!!.results)
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