package com.example.movies.fragment.factory.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.R
import com.example.movies.fragment.repository.detail.ReviewMovieRepository
import com.example.movies.fragment.viewmodel.detail.ReviewMovieViewModel

@Suppress("UNCHECKED_CAST")
class ReviewFactory(
    private val reviewMovieRepository: ReviewMovieRepository,
    application: Application
) : ViewModelProvider.Factory {
    private val appContext = application.applicationContext
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReviewMovieViewModel::class.java)) {
            return ReviewMovieViewModel(reviewMovieRepository) as T
        } else {
            throw IllegalArgumentException(appContext.getString(R.string.factory, "Review"))
        }
    }
}