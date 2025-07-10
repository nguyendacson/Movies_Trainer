package com.example.movies.fragment.viewmodel.menu;

import androidx.lifecycle.ViewModel;
import com.example.movies.fragment.repository.menu.WatchListMovieRepository;
import com.example.movies.database.movie.MovieData;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/movies/fragment/viewmodel/menu/WatchListViewModel;", "Landroidx/lifecycle/ViewModel;", "watchListMovieRepository", "Lcom/example/movies/fragment/repository/menu/WatchListMovieRepository;", "(Lcom/example/movies/fragment/repository/menu/WatchListMovieRepository;)V", "_watchListMovie", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/movies/database/movie/MovieData;", "watchListMovie", "Lkotlinx/coroutines/flow/StateFlow;", "getWatchListMovie", "()Lkotlinx/coroutines/flow/StateFlow;", "fetchMovies", "", "refresh", "app_debug"})
public final class WatchListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.movies.fragment.repository.menu.WatchListMovieRepository watchListMovieRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.movies.database.movie.MovieData>> _watchListMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.movies.database.movie.MovieData>> watchListMovie = null;
    
    public WatchListViewModel(@org.jetbrains.annotations.NotNull()
    com.example.movies.fragment.repository.menu.WatchListMovieRepository watchListMovieRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.movies.database.movie.MovieData>> getWatchListMovie() {
        return null;
    }
    
    public final void refresh() {
    }
    
    private final void fetchMovies() {
    }
}