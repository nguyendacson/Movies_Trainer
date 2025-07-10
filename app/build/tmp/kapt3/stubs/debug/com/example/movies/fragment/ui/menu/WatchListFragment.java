package com.example.movies.fragment.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.movies.adapter.movie.AdapterMovie;
import com.example.movies.api.ApiMovie;
import com.example.movies.database.movie.MovieCategory;
import com.example.movies.database.movie.MovieData;
import com.example.movies.databinding.FragmentWatchlistBinding;
import com.example.movies.fragment.factory.menu.WatchListFactory;
import com.example.movies.fragment.repository.menu.WatchListMovieRepository;
import com.example.movies.fragment.viewmodel.menu.WatchListViewModel;
import java.time.LocalDate;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/movies/fragment/ui/menu/WatchListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/movies/databinding/FragmentWatchlistBinding;", "getBinding", "()Lcom/example/movies/databinding/FragmentWatchlistBinding;", "viewModel", "Lcom/example/movies/fragment/viewmodel/menu/WatchListViewModel;", "getViewModel", "()Lcom/example/movies/fragment/viewmodel/menu/WatchListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "watchListAdapter", "Lcom/example/movies/adapter/movie/AdapterMovie;", "watchListBinding", "onClickItem", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "sentDataNavGraph", "data", "Lcom/example/movies/database/movie/MovieData;", "app_debug"})
public final class WatchListFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.movies.databinding.FragmentWatchlistBinding watchListBinding;
    @org.jetbrains.annotations.Nullable()
    private com.example.movies.adapter.movie.AdapterMovie watchListAdapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public WatchListFragment() {
        super();
    }
    
    private final com.example.movies.databinding.FragmentWatchlistBinding getBinding() {
        return null;
    }
    
    private final com.example.movies.fragment.viewmodel.menu.WatchListViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
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
}