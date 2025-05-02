package com.example.movies.fragment.factory.menu

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.R
import com.example.movies.fragment.repository.menu.HomeMovieRepository
import com.example.movies.fragment.viewmodel.menu.HomeViewModel

@Suppress("UNCHECKED_CAST")
class HomeFactory(private val homeMovieRepository: HomeMovieRepository, application: Application) :
    ViewModelProvider.Factory {
    private val appContext = application.applicationContext
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(homeMovieRepository) as T
        } else {
            throw IllegalArgumentException(appContext.getString(R.string.factory, "Home"))
        }
    }
}