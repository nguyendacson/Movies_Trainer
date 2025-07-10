package com.example.movies.fragment.repository.detail;

import android.app.Application;
import com.example.movies.R;
import com.example.movies.api.ApiMovie;
import com.example.movies.database.movie.DetailResponse;
import com.example.movies.database.movie.WatchListPostData;
import kotlinx.coroutines.flow.Flow;
import retrofit2.Response;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eJ&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/movies/fragment/repository/detail/DetailMovieRepository;", "", "apiMovie", "Lcom/example/movies/api/ApiMovie;", "application", "Landroid/app/Application;", "(Lcom/example/movies/api/ApiMovie;Landroid/app/Application;)V", "appContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getDetails", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/movies/database/movie/DetailResponse;", "query", "", "postToWatchlist", "Lretrofit2/Response;", "", "id", "", "save", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class DetailMovieRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.movies.api.ApiMovie apiMovie = null;
    private final android.content.Context appContext = null;
    
    public DetailMovieRepository(@org.jetbrains.annotations.NotNull()
    com.example.movies.api.ApiMovie apiMovie, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.movies.database.movie.DetailResponse> getDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object postToWatchlist(int id, boolean save, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion) {
        return null;
    }
}