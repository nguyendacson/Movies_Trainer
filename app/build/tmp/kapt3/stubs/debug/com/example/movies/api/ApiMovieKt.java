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

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0004"}, d2 = {"API_KEY", "", "BASE_URL", "HEADER", "app_debug"})
public final class ApiMovieKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String API_KEY = "ebafae2fa106a49243a4dcb8017e34f8";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "https://api.themoviedb.org/3/";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String HEADER = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlYmFmYWUyZmExMDZhNDkyNDNhNGRjYjgwMTdlMzRmOCIsIm5iZiI6MTc0MTA2OTA3Ni45OTIsInN1YiI6IjY3YzY5YjE0NTk4ZTIxMzA0YTA0ZGEzMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Xm9q-0cHzvZVxDrx-XcdjB1aElYY6gLnw-y1qla1C-E";
}