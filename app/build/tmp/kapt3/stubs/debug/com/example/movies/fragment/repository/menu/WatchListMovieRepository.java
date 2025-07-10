package com.example.movies.fragment.repository.menu;

import android.app.Application;
import android.util.Log;
import com.example.movies.R;
import com.example.movies.api.ApiMovie;
import com.example.movies.database.movie.MovieCategory;
import com.example.movies.database.movie.MovieData;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/movies/fragment/repository/menu/WatchListMovieRepository;", "", "apiMovie", "Lcom/example/movies/api/ApiMovie;", "application", "Landroid/app/Application;", "(Lcom/example/movies/api/ApiMovie;Landroid/app/Application;)V", "appContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getWatchListMovie", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/movies/database/movie/MovieData;", "app_debug"})
public final class WatchListMovieRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.movies.api.ApiMovie apiMovie = null;
    private final android.content.Context appContext = null;
    
    public WatchListMovieRepository(@org.jetbrains.annotations.NotNull()
    com.example.movies.api.ApiMovie apiMovie, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.movies.database.movie.MovieData>> getWatchListMovie() {
        return null;
    }
}