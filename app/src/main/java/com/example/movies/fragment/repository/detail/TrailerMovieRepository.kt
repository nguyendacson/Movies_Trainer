package com.example.movies.fragment.repository.detail

import android.app.Application
import com.example.movies.R
import com.example.movies.api.ApiMovie
import com.example.movies.database.movie.Trailer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TrailerMovieRepository(private val apiMovie: ApiMovie, application: Application) {

    private val appContext = application.applicationContext
    fun trailerMovies(query: String): Flow<List<Trailer>> = flow {
        try {
            val response = apiMovie.getTrailer(query)
            if (response.isSuccessful) {
                emit(response.body()?.results
                    ?.filter { it.type == "Trailer" && it.official } ?: emptyList())
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