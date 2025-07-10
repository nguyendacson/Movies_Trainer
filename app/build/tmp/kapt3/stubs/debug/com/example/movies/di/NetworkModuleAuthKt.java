package com.example.movies.di;

import com.example.movies.api.ApiAuth;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0002"}, d2 = {"BASE_URL", "", "app_debug"})
public final class NetworkModuleAuthKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "https://api.escuelajs.co/api/v1/";
}