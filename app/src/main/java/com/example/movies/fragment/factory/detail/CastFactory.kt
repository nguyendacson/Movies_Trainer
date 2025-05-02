package com.example.movies.fragment.factory.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.R
import com.example.movies.fragment.repository.detail.CastMovieRepository
import com.example.movies.fragment.viewmodel.detail.CastMovieViewModel

@Suppress("UNCHECKED_CAST")
class CastFactory(private val castMovieRepository: CastMovieRepository, application: Application) :
    ViewModelProvider.Factory {
    private val appContext = application.applicationContext
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CastMovieViewModel::class.java)) {
            return CastMovieViewModel(castMovieRepository) as T
        } else {
            throw IllegalArgumentException(appContext.getString(R.string.factory, "Cast"))
        }
    }
}