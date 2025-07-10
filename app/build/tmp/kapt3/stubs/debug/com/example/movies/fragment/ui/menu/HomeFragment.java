package com.example.movies.fragment.ui.menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.movies.R;
import com.example.movies.adapter.movie.AdapterMovie;
import com.example.movies.api.ApiMovie;
import com.example.movies.database.movie.MovieData;
import com.example.movies.databinding.FragmentHomeBinding;
import com.example.movies.fragment.factory.menu.HomeFactory;
import com.example.movies.fragment.repository.menu.HomeMovieRepository;
import com.example.movies.fragment.viewmodel.menu.HomeViewModel;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JE\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00132\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0002\u00a2\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u001a\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\'H\u0002J\b\u0010(\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006)"}, d2 = {"Lcom/example/movies/fragment/ui/menu/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/movies/databinding/FragmentHomeBinding;", "nowPlayingAdapter", "Lcom/example/movies/adapter/movie/AdapterMovie;", "topRatedAdapter", "trendingAdapter", "viewModel", "Lcom/example/movies/fragment/viewmodel/menu/HomeViewModel;", "getViewModel", "()Lcom/example/movies/fragment/viewmodel/menu/HomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "collectLatestFlow", "", "T", "flow", "Lkotlinx/coroutines/flow/StateFlow;", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/jvm/functions/Function2;)V", "observeLoading", "onClickItem", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "sentDataNavGraph", "data", "Lcom/example/movies/database/movie/MovieData;", "setupView", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    private com.example.movies.databinding.FragmentHomeBinding binding;
    @org.jetbrains.annotations.Nullable()
    private com.example.movies.adapter.movie.AdapterMovie topRatedAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.example.movies.adapter.movie.AdapterMovie nowPlayingAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.example.movies.adapter.movie.AdapterMovie trendingAdapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public HomeFragment() {
        super();
    }
    
    private final com.example.movies.fragment.viewmodel.menu.HomeViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void onClickItem() {
    }
    
    private final void sentDataNavGraph(com.example.movies.database.movie.MovieData data) {
    }
    
    private final void setupView() {
    }
    
    private final <T extends java.lang.Object>void collectLatestFlow(kotlinx.coroutines.flow.StateFlow<? extends T> flow, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> action) {
    }
    
    private final void observeLoading(com.example.movies.fragment.viewmodel.menu.HomeViewModel viewModel) {
    }
}