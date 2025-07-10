package com.example.movies.fragment.factory.menu;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.movies.R;
import com.example.movies.fragment.repository.menu.HomeMovieRepository;
import com.example.movies.fragment.viewmodel.menu.HomeViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J%\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0016\u00a2\u0006\u0002\u0010\u000fR\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/movies/fragment/factory/menu/HomeFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "homeMovieRepository", "Lcom/example/movies/fragment/repository/menu/HomeMovieRepository;", "application", "Landroid/app/Application;", "(Lcom/example/movies/fragment/repository/menu/HomeMovieRepository;Landroid/app/Application;)V", "appContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
@kotlin.Suppress(names = {"UNCHECKED_CAST"})
public final class HomeFactory implements androidx.lifecycle.ViewModelProvider.Factory {
    @org.jetbrains.annotations.NotNull()
    private final com.example.movies.fragment.repository.menu.HomeMovieRepository homeMovieRepository = null;
    private final android.content.Context appContext = null;
    
    public HomeFactory(@org.jetbrains.annotations.NotNull()
    com.example.movies.fragment.repository.menu.HomeMovieRepository homeMovieRepository, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass) {
        return null;
    }
}