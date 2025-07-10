package com.example.movies.fragment.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.movies.databinding.FragmentFilterBinding;
import com.example.movies.fragment.viewmodel.FilterViewModel;
import com.example.movies.database.movie.SortDirection;
import com.example.movies.database.movie.SortField;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0016H\u0002J \u0010%\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00162\u0006\u0010\'\u001a\u00020\u0016H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006("}, d2 = {"Lcom/example/movies/fragment/ui/FilterFragment;", "Landroidx/fragment/app/Fragment;", "()V", "args", "Lcom/example/movies/fragment/ui/FilterFragmentArgs;", "getArgs", "()Lcom/example/movies/fragment/ui/FilterFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "binding", "Lcom/example/movies/databinding/FragmentFilterBinding;", "filterViewModel", "Lcom/example/movies/fragment/viewmodel/FilterViewModel;", "getFilterViewModel", "()Lcom/example/movies/fragment/viewmodel/FilterViewModel;", "filterViewModel$delegate", "Lkotlin/Lazy;", "getCurrentDirection", "Lcom/example/movies/database/movie/SortDirection;", "getCurrentField", "Lcom/example/movies/database/movie/SortField;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setText", "setupClicks", "updateSortUI", "show", "hide", "updateTypeUI", "hide1", "hide2", "app_debug"})
public final class FilterFragment extends androidx.fragment.app.Fragment {
    private com.example.movies.databinding.FragmentFilterBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy filterViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    
    public FilterFragment() {
        super();
    }
    
    private final com.example.movies.fragment.viewmodel.FilterViewModel getFilterViewModel() {
        return null;
    }
    
    private final com.example.movies.fragment.ui.FilterFragmentArgs getArgs() {
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
    
    private final void setText() {
    }
    
    private final void setupClicks() {
    }
    
    private final void updateSortUI(android.view.View show, android.view.View hide) {
    }
    
    private final void updateTypeUI(android.view.View show, android.view.View hide1, android.view.View hide2) {
    }
    
    private final com.example.movies.database.movie.SortDirection getCurrentDirection() {
        return null;
    }
    
    private final com.example.movies.database.movie.SortField getCurrentField() {
        return null;
    }
}