package com.example.movies.fragment.repository.menu

import android.util.Log
import com.example.movies.api.ApiMovie
import com.example.movies.database.movie.MovieCategory
import com.example.movies.database.movie.MovieData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchMovieRepository(private val apiService: ApiMovie) {
    fun searchMovies(query: String): Flow<List<MovieData>> = flow {
        try {
            val response = apiService.getMoviesSearch(query)
            if (response.isSuccessful) {
                emit(response.body()?.results?.map { movie ->
                    movie.copy(
                        category = movie.category ?: MovieCategory.SEARCH
                    )
                } ?: emptyList())
            } else {
                Log.e("SearchRepository", "Lỗi API: ${response.code()} - ${response.message()}")
                emit(emptyList())
            }
        } catch (e: Exception) {
            Log.e("SearchRepository", "Lỗi khi gọi API: ${e.localizedMessage}")
            emit(emptyList())
        }
    }
}


