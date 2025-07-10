package com.example.movies.fragment.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.movies.R;
import com.example.movies.adapter.movie.AdapterMovie;
import com.example.movies.api.ApiMovie;
import com.example.movies.database.movie.MovieData;
import com.example.movies.database.movie.SortDirection;
import com.example.movies.database.movie.SortField;
import com.example.movies.databinding.FragmentAllMovieNowPlayBinding;
import com.example.movies.fragment.factory.menu.HomeFactory;
import com.example.movies.fragment.repository.menu.HomeMovieRepository;
import com.example.movies.fragment.viewmodel.FilterViewModel;
import com.example.movies.fragment.viewmodel.menu.HomeViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006#"}, d2 = {"Lcom/example/movies/fragment/ui/menu/AllMovieNowPlayFragment;", "Landroidx/fragment/app/Fragment;", "()V", "allMovieNowPlayAdapter", "Lcom/example/movies/adapter/movie/AdapterMovie;", "binding", "Lcom/example/movies/databinding/FragmentAllMovieNowPlayBinding;", "filterViewModel", "Lcom/example/movies/fragment/viewmodel/FilterViewModel;", "getFilterViewModel", "()Lcom/example/movies/fragment/viewmodel/FilterViewModel;", "filterViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/example/movies/fragment/viewmodel/menu/HomeViewModel;", "getViewModel", "()Lcom/example/movies/fragment/viewmodel/menu/HomeViewModel;", "viewModel$delegate", "observeAndSortAllPlay", "", "allMovieNowPLayViewModel", "onClickIem", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "sentDataDetail", "data", "Lcom/example/movies/database/movie/MovieData;", "app_debug"})
public final class AllMovieNowPlayFragment extends androidx.fragment.app.Fragment {
    private com.example.movies.databinding.FragmentAllMovieNowPlayBinding binding;
    @org.jetbrains.annotations.Nullable()
    private com.example.movies.adapter.movie.AdapterMovie allMovieNowPlayAdapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy filterViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public AllMovieNowPlayFragment() {
        super();
    }
    
    private final com.example.movies.fragment.viewmodel.FilterViewModel getFilterViewModel() {
        return null;
    }
    
    private final com.example.movies.fragment.viewmodel.menu.HomeViewModel getViewModel() {
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
    
    private final void observeAndSortAllPlay(com.example.movies.fragment.viewmodel.menu.HomeViewModel allMovieNowPLayViewModel, com.example.movies.fragment.viewmodel.FilterViewModel filterViewModel) {
    }
    
    private final void sentDataDetail(com.example.movies.database.movie.MovieData data) {
    }
    
    private final void onClickIem() {
    }
}