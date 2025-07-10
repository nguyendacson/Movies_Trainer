package com.example.movies.fragment.repository.menu;

import android.util.Log;
import com.example.movies.api.ApiMovie;
import com.example.movies.database.movie.MovieCategory;
import com.example.movies.database.movie.MovieData;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/movies/fragment/repository/menu/SearchMovieRepository;", "", "apiService", "Lcom/example/movies/api/ApiMovie;", "(Lcom/example/movies/api/ApiMovie;)V", "searchMovies", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/movies/database/movie/MovieData;", "query", "", "app_debug"})
public final class SearchMovieRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.movies.api.ApiMovie apiService = null;
    
    public SearchMovieRepository(@org.jetbrains.annotations.NotNull()
    com.example.movies.api.ApiMovie apiService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.movies.database.movie.MovieData>> searchMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
}