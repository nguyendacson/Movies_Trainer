package com.example.movies.fragment.factory.menu

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.R
import com.example.movies.fragment.repository.menu.WatchListMovieRepository
import com.example.movies.fragment.viewmodel.menu.WatchListViewModel

@Suppress("UNCHECKED_CAST")
class WatchListFactory(
    private val watchListMovieRepository: WatchListMovieRepository, application: Application
) : ViewModelProvider.Factory {
    private val appContext = application.applicationContext
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WatchListViewModel::class.java)) {
            return WatchListViewModel(watchListMovieRepository) as T
        } else {
            throw IllegalArgumentException(appContext.getString(R.string.factory, "WatchList"))
        }
    }
}
