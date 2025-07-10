package com.example.movies.api;

import com.example.movies.database.movie.CastResponse;
import com.example.movies.database.movie.DetailResponse;
import com.example.movies.database.movie.MovieResponse;
import com.example.movies.database.movie.ReviewResponse;
import com.example.movies.database.movie.TrailerResponse;
import com.example.movies.database.movie.WatchListPostData;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 32\u00020\u0001:\u00013J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\bJF\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u000b\u001a\u00020\u00062\b\b\u0003\u0010\f\u001a\u00020\u00062\b\b\u0003\u0010\r\u001a\u00020\u00062\b\b\u0003\u0010\u000e\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ2\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0003\u0010\u0012\u001a\u00020\u00062\b\b\u0003\u0010\f\u001a\u00020\u00062\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u0015JF\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0017\u001a\u00020\u00062\b\b\u0003\u0010\u0018\u001a\u00020\u00192\b\b\u0003\u0010\f\u001a\u00020\u00062\b\b\u0003\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u0012\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u001aJd\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0003\u0010\u0012\u001a\u00020\u00062\b\b\u0003\u0010\u0018\u001a\u00020\u00192\b\b\u0003\u0010\u001c\u001a\u00020\u00192\b\b\u0003\u0010\f\u001a\u00020\u00062\b\b\u0003\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u001d\u001a\u00020\u00062\b\b\u0003\u0010\u001e\u001a\u00020\u00062\b\b\u0003\u0010\u001f\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010 Jd\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\u0018\u001a\u00020\u00192\b\b\u0003\u0010\u001c\u001a\u00020\u00192\b\b\u0003\u0010\f\u001a\u00020\u00062\b\b\u0003\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u001d\u001a\u00020\u00062\b\b\u0003\u0010\"\u001a\u00020\u00062\b\b\u0003\u0010#\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010$J(\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\bJ2\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\f\u001a\u00020\u00062\b\b\u0003\u0010)\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010*JF\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0003\u0010,\u001a\u00020\u00142\b\b\u0003\u0010\f\u001a\u00020\u00062\b\b\u0003\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u001d\u001a\u00020\u00062\b\b\u0003\u0010\u000e\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010-J2\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00032\b\b\u0003\u0010,\u001a\u00020\u00142\b\b\u0003\u0010)\u001a\u00020\u00062\b\b\u0001\u00100\u001a\u000201H\u00a7@\u00a2\u0006\u0002\u00102\u00a8\u00064"}, d2 = {"Lcom/example/movies/api/ApiMovie;", "", "getCastMovieDetail", "Lretrofit2/Response;", "Lcom/example/movies/database/movie/CastResponse;", "movieId", "", "apikey", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDetailMovies", "Lcom/example/movies/database/movie/DetailResponse;", "appendResponse", "language", "sessionId", "authorization", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMoviesNowPlaying", "Lcom/example/movies/database/movie/MovieResponse;", "apiKey", "page", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMoviesSearch", "query", "includeAdult", "", "(Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMoviesTopRated", "includeVideo", "sortBy", "withoutGenres", "voteCountGte", "(Ljava/lang/String;ZZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMoviesTrending", "minDate", "maxDate", "(Ljava/lang/String;ZZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReviewMovieDetail", "Lcom/example/movies/database/movie/ReviewResponse;", "getTrailer", "Lcom/example/movies/database/movie/TrailerResponse;", "auth", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWatchListMovie", "accountId", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postToWatchlist", "", "requestBody", "Lcom/example/movies/database/movie/WatchListPostData;", "(ILjava/lang/String;Lcom/example/movies/database/movie/WatchListPostData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface ApiMovie {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.movies.api.ApiMovie.Companion Companion = null;
    
    @retrofit2.http.GET(value = "discover/movie")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMoviesTopRated(@retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "include_adult")
    boolean includeAdult, @retrofit2.http.Query(value = "include_video")
    boolean includeVideo, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "sort_by")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sortBy, @retrofit2.http.Query(value = "without_genres")
    @org.jetbrains.annotations.NotNull()
    java.lang.String withoutGenres, @retrofit2.http.Query(value = "vote_count.gte")
    int voteCountGte, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.movies.database.movie.MovieResponse>> $completion);
    
    @retrofit2.http.GET(value = "movie/now_playing")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMoviesNowPlaying(@retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.movies.database.movie.MovieResponse>> $completion);
    
    @retrofit2.http.GET(value = "discover/movie")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMoviesTrending(@retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apikey, @retrofit2.http.Query(value = "include_adult")
    boolean includeAdult, @retrofit2.http.Query(value = "include_video")
    boolean includeVideo, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "sort_by")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sortBy, @retrofit2.http.Query(value = "release_date.gte")
    @org.jetbrains.annotations.NotNull()
    java.lang.String minDate, @retrofit2.http.Query(value = "release_date.lte")
    @org.jetbrains.annotations.NotNull()
    java.lang.String maxDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.movies.database.movie.MovieResponse>> $completion);
    
    @retrofit2.http.GET(value = "search/multi")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMoviesSearch(@retrofit2.http.Query(value = "query")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @retrofit2.http.Query(value = "include_adult")
    boolean includeAdult, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.movies.database.movie.MovieResponse>> $completion);
    
    @retrofit2.http.GET(value = "movie/{movie_id}/reviews")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getReviewMovieDetail(@retrofit2.http.Path(value = "movie_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String movieId, @retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apikey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.movies.database.movie.ReviewResponse>> $completion);
    
    @retrofit2.http.GET(value = "movie/{movie_id}/credits")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCastMovieDetail(@retrofit2.http.Path(value = "movie_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String movieId, @retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apikey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.movies.database.movie.CastResponse>> $completion);
    
    @retrofit2.http.GET(value = "account/{account_id}/watchlist/movies")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getWatchListMovie(@retrofit2.http.Query(value = "account_id")
    int accountId, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "sort_by")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sortBy, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authorization, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.movies.database.movie.MovieResponse>> $completion);
    
    @retrofit2.http.GET(value = "movie/{movie_id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDetailMovies(@retrofit2.http.Path(value = "movie_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String movieId, @retrofit2.http.Query(value = "append_to_response")
    @org.jetbrains.annotations.NotNull()
    java.lang.String appendResponse, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "session_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sessionId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authorization, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.movies.database.movie.DetailResponse>> $completion);
    
    @retrofit2.http.POST(value = "account/{account_id}/watchlist")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object postToWatchlist(@retrofit2.http.Path(value = "account_id")
    int accountId, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String auth, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.movies.database.movie.WatchListPostData requestBody, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "movie/{movie_id}/videos")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTrailer(@retrofit2.http.Path(value = "movie_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String movieId, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String auth, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.movies.database.movie.TrailerResponse>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/example/movies/api/ApiMovie$Companion;", "", "()V", "instance", "Lcom/example/movies/api/ApiMovie;", "getInstance", "()Lcom/example/movies/api/ApiMovie;", "instance$delegate", "Lkotlin/Lazy;", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        private static final kotlin.Lazy<?> instance$delegate = null;
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.movies.api.ApiMovie getInstance() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}