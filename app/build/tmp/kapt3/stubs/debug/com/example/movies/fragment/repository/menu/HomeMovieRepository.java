package com.example.movies.fragment.repository.menu;

import com.example.movies.api.ApiMovie;
import com.example.movies.database.movie.MovieCategory;
import com.example.movies.database.movie.MovieData;
import com.example.movies.database.movie.MovieResponse;
import kotlinx.coroutines.flow.Flow;
import retrofit2.Response;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JE\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\"\u0010\t\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u00a2\u0006\u0002\u0010\u0010JE\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\"\u0010\t\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u00a2\u0006\u0002\u0010\u0010J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/movies/fragment/repository/menu/HomeMovieRepository;", "", "apiMovie", "Lcom/example/movies/api/ApiMovie;", "(Lcom/example/movies/api/ApiMovie;)V", "fetchAllMovies", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/movies/database/movie/MovieData;", "apiCall", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "Lcom/example/movies/database/movie/MovieResponse;", "category", "Lcom/example/movies/database/movie/MovieCategory;", "(Lkotlin/jvm/functions/Function1;Lcom/example/movies/database/movie/MovieCategory;)Lkotlinx/coroutines/flow/Flow;", "fetchMovies", "getAllNowPlayMovies", "getAllTrendingMovies", "getNowPlayMovies", "getTopRatedMovies", "getTrendingMovies", "app_debug"})
public final class HomeMovieRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.movies.api.ApiMovie apiMovie = null;
    
    public HomeMovieRepository(@org.jetbrains.annotations.NotNull()
    com.example.movies.api.ApiMovie apiMovie) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.movies.database.movie.MovieData>> getTopRatedMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.movies.database.movie.MovieData>> getNowPlayMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.movies.database.movie.MovieData>> getAllNowPlayMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.movies.database.movie.MovieData>> getTrendingMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.movies.database.movie.MovieData>> getAllTrendingMovies() {
        return null;
    }
    
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.movies.database.movie.MovieData>> fetchMovies(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.movies.database.movie.MovieResponse>>, ? extends java.lang.Object> apiCall, com.example.movies.database.movie.MovieCategory category) {
        return null;
    }
    
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.movies.database.movie.MovieData>> fetchAllMovies(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.movies.database.movie.MovieResponse>>, ? extends java.lang.Object> apiCall, com.example.movies.database.movie.MovieCategory category) {
        return null;
    }
}