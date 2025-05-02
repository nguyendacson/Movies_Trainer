package com.example.movies.fragment.viewmodel

import androidx.lifecycle.ViewModel
import com.example.movies.database.movie.SortDirection
import com.example.movies.database.movie.SortField
import com.example.movies.database.movie.SortState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor() : ViewModel() {

    private val _sortState = MutableStateFlow(SortState())
    val sortState: StateFlow<SortState> = _sortState.asStateFlow()

    fun updateSortState(direction: SortDirection?, field: SortField?) {
        _sortState.value = SortState(direction, field)
    }
}