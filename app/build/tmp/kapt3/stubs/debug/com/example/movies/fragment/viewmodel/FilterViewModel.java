package com.example.movies.fragment.viewmodel;

import androidx.lifecycle.ViewModel;
import com.example.movies.database.movie.SortDirection;
import com.example.movies.database.movie.SortField;
import com.example.movies.database.movie.SortState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/example/movies/fragment/viewmodel/FilterViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_sortState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/movies/database/movie/SortState;", "sortState", "Lkotlinx/coroutines/flow/StateFlow;", "getSortState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateSortState", "", "direction", "Lcom/example/movies/database/movie/SortDirection;", "field", "Lcom/example/movies/database/movie/SortField;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class FilterViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.movies.database.movie.SortState> _sortState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.movies.database.movie.SortState> sortState = null;
    
    @javax.inject.Inject()
    public FilterViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.movies.database.movie.SortState> getSortState() {
        return null;
    }
    
    public final void updateSortState(@org.jetbrains.annotations.Nullable()
    com.example.movies.database.movie.SortDirection direction, @org.jetbrains.annotations.Nullable()
    com.example.movies.database.movie.SortField field) {
    }
}