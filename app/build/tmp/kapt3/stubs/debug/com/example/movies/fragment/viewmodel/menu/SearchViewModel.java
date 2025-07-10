package com.example.movies.fragment.viewmodel.menu;

import androidx.lifecycle.ViewModel;
import com.example.movies.fragment.repository.menu.SearchMovieRepository;
import com.example.movies.database.movie.MovieData;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/movies/fragment/viewmodel/menu/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "searchMovieRepository", "Lcom/example/movies/fragment/repository/menu/SearchMovieRepository;", "(Lcom/example/movies/fragment/repository/menu/SearchMovieRepository;)V", "_searchMovies", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/movies/database/movie/MovieData;", "searchMovies", "Lkotlinx/coroutines/flow/StateFlow;", "getSearchMovies", "()Lkotlinx/coroutines/flow/StateFlow;", "", "nameMovie", "", "app_debug"})
public final class SearchViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.movies.fragment.repository.menu.SearchMovieRepository searchMovieRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.movies.database.movie.MovieData>> _searchMovies = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.movies.database.movie.MovieData>> searchMovies = null;
    
    public SearchViewModel(@org.jetbrains.annotations.NotNull()
    com.example.movies.fragment.repository.menu.SearchMovieRepository searchMovieRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.movies.database.movie.MovieData>> getSearchMovies() {
        return null;
    }
    
    public final void searchMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String nameMovie) {
    }
}