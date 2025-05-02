package com.example.movies.fragment.factory.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.R
import com.example.movies.fragment.repository.detail.DetailMovieRepository
import com.example.movies.fragment.viewmodel.detail.DetailMovieViewModel

@Suppress("UNCHECKED_CAST")
class DetailFactory(
    private val detailMovieRepository: DetailMovieRepository, application: Application
) : ViewModelProvider.Factory {
    private val appContext = application.applicationContext
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailMovieViewModel::class.java)) {
            return DetailMovieViewModel(detailMovieRepository) as T
        }
        throw IllegalArgumentException(appContext.getString(R.string.factory, "Detail"))
    }
}