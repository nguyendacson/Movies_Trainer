package com.example.movies.fragment.ui.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.movies.adapter.detail.AdapterMovieReview;
import com.example.movies.api.ApiMovie;
import com.example.movies.databinding.FragmentReviewMovieBinding;
import com.example.movies.fragment.factory.detail.ReviewFactory;
import com.example.movies.fragment.repository.detail.ReviewMovieRepository;
import com.example.movies.fragment.ui.ErrorView;
import com.example.movies.fragment.viewmodel.detail.ReviewMovieViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0003J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001c"}, d2 = {"Lcom/example/movies/fragment/ui/detail/ReviewMovieFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapterReview", "Lcom/example/movies/adapter/detail/AdapterMovieReview;", "binding", "Lcom/example/movies/databinding/FragmentReviewMovieBinding;", "viewModel", "Lcom/example/movies/fragment/viewmodel/detail/ReviewMovieViewModel;", "getViewModel", "()Lcom/example/movies/fragment/viewmodel/detail/ReviewMovieViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeError", "", "observeLoading", "observeReview", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupRecyclerView", "app_debug"})
public final class ReviewMovieFragment extends androidx.fragment.app.Fragment {
    private com.example.movies.databinding.FragmentReviewMovieBinding binding;
    @org.jetbrains.annotations.Nullable()
    private com.example.movies.adapter.detail.AdapterMovieReview adapterReview;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public ReviewMovieFragment() {
        super();
    }
    
    private final com.example.movies.fragment.viewmodel.detail.ReviewMovieViewModel getViewModel() {
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
    
    private final void setupRecyclerView() {
    }
    
    private final void observeReview(com.example.movies.fragment.viewmodel.detail.ReviewMovieViewModel viewModel) {
    }
    
    private final void observeLoading(com.example.movies.fragment.viewmodel.detail.ReviewMovieViewModel viewModel) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void observeError(com.example.movies.fragment.viewmodel.detail.ReviewMovieViewModel viewModel) {
    }
}