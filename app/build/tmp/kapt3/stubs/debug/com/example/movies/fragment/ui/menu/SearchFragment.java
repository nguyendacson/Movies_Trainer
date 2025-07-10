package com.example.movies.fragment.ui.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.movies.R;
import com.example.movies.adapter.movie.AdapterMovie;
import com.example.movies.api.ApiMovie;
import com.example.movies.database.movie.MovieCategory;
import com.example.movies.database.movie.MovieData;
import com.example.movies.database.movie.SortDirection;
import com.example.movies.database.movie.SortField;
import com.example.movies.databinding.FragmentSearchBinding;
import com.example.movies.fragment.factory.menu.SearchFactory;
import com.example.movies.fragment.repository.menu.SearchMovieRepository;
import com.example.movies.fragment.viewmodel.FilterViewModel;
import com.example.movies.fragment.viewmodel.menu.SearchViewModel;
import java.time.LocalDate;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\u001a\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010\'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u0018H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006*"}, d2 = {"Lcom/example/movies/fragment/ui/menu/SearchFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/movies/databinding/FragmentSearchBinding;", "getBinding", "()Lcom/example/movies/databinding/FragmentSearchBinding;", "filterViewModel", "Lcom/example/movies/fragment/viewmodel/FilterViewModel;", "getFilterViewModel", "()Lcom/example/movies/fragment/viewmodel/FilterViewModel;", "filterViewModel$delegate", "Lkotlin/Lazy;", "searchAdapter", "Lcom/example/movies/adapter/movie/AdapterMovie;", "searchBinding", "viewModel", "Lcom/example/movies/fragment/viewmodel/menu/SearchViewModel;", "getViewModel", "()Lcom/example/movies/fragment/viewmodel/menu/SearchViewModel;", "viewModel$delegate", "isTablet", "", "observeAndSortSearch", "", "searchViewModel", "onClickItem", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", "view", "sentDataNavGraph", "data", "Lcom/example/movies/database/movie/MovieData;", "sentTitleFilter", "app_debug"})
public final class SearchFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.movies.databinding.FragmentSearchBinding searchBinding;
    @org.jetbrains.annotations.Nullable()
    private com.example.movies.adapter.movie.AdapterMovie searchAdapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy filterViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public SearchFragment() {
        super();
    }
    
    private final com.example.movies.databinding.FragmentSearchBinding getBinding() {
        return null;
    }
    
    private final com.example.movies.fragment.viewmodel.FilterViewModel getFilterViewModel() {
        return null;
    }
    
    private final com.example.movies.fragment.viewmodel.menu.SearchViewModel getViewModel() {
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
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean isTablet() {
        return false;
    }
    
    private final void onClickItem() {
    }
    
    private final void observeAndSortSearch(com.example.movies.fragment.viewmodel.menu.SearchViewModel searchViewModel, com.example.movies.fragment.viewmodel.FilterViewModel filterViewModel) {
    }
    
    private final void sentDataNavGraph(com.example.movies.database.movie.MovieData data) {
    }
    
    private final void sentTitleFilter() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
}