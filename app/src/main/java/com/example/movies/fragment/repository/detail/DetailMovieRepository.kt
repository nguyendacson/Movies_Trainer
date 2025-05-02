package com.example.movies.fragment.repository.detail

import android.app.Application
import com.example.movies.R
import com.example.movies.api.ApiMovie
import com.example.movies.database.movie.DetailResponse
import com.example.movies.database.movie.WatchListPostData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class DetailMovieRepository(
    private val apiMovie: ApiMovie, application: Application
) {
    private val appContext = application.applicationContext
    fun getDetails(query: String): Flow<DetailResponse> = flow {
        try {
            val response = apiMovie.getDetailMovies(query)
            if (response.isSuccessful && response.body() != null) {
                emit(response.body()!!)
            } else {
                println(appContext.getString(R.string.Fails, "API"))
            }
        } catch (e: Exception) {
            println("${appContext.getString(R.string.Fails, "API")}: ${e.message}")
        }
    }

    suspend fun postToWatchlist(id: Int, save: Boolean): Response<Unit>? {
        val watchListPostData = WatchListPostData(
            media_type = "movie",
            media_id = id,
            watchlist = save
        )
        return try {
            val response = apiMovie.postToWatchlist(requestBody = watchListPostData)
            if (response.isSuccessful) {
                println(appContext.getString(R.string.Success, "Call List"))
            } else {
                println(appContext.getString(R.string.Fails, "Call List"))
            }
            response
        } catch (e: Exception) {
            println("${appContext.getString(R.string.Fails, "API")}: ${e.message}")
            null
        }
    }
}