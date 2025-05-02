package com.example.movies.fragment.factory.menu

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.R
import com.example.movies.fragment.repository.menu.SearchMovieRepository
import com.example.movies.fragment.viewmodel.menu.SearchViewModel

@Suppress("UNCHECKED_CAST")
class SearchFactory(private val repository: SearchMovieRepository, application: Application) :
    ViewModelProvider.Factory {
    private val appContext = application.applicationContext
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(repository) as T
        } else {
            throw IllegalArgumentException(appContext.getString(R.string.factory, "Search"))
        }
    }
}
