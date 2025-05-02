package com.example.movies.fragment.factory.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.R
import com.example.movies.fragment.repository.detail.TrailerMovieRepository
import com.example.movies.fragment.viewmodel.detail.TrailerMovieViewModel

@Suppress("UNCHECKED_CAST")
class TrailerFactory(
    private val trailerMovieRepository: TrailerMovieRepository,
    application: Application
) :
    ViewModelProvider.Factory {
    private val appContext = application.applicationContext
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrailerMovieViewModel::class.java)) {
            return TrailerMovieViewModel(trailerMovieRepository) as T
        } else {
            throw IllegalArgumentException(appContext.getString(R.string.factory, "Cast"))

        }
    }
}