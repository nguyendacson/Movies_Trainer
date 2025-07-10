package com.example.movies.fragment.ui.detail;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.example.movies.R;
import com.example.movies.api.ApiMovie;
import com.example.movies.database.movie.MovieData;
import com.example.movies.databinding.FragmentDetailBinding;
import com.example.movies.fragment.factory.detail.DetailFactory;
import com.example.movies.fragment.repository.detail.DetailMovieRepository;
import com.example.movies.fragment.ui.ErrorView;
import com.example.movies.fragment.viewmodel.detail.DetailMovieViewModel;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u001e\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u0015H\u0002J2\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\u00152\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150&2\b\b\u0002\u0010\'\u001a\u00020\u0015H\u0002J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J$\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0017J\u0018\u00105\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u0015H\u0002J@\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020,H\u0002J\b\u0010@\u001a\u00020\u001dH\u0002J\b\u0010A\u001a\u00020\u001dH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006B"}, d2 = {"Lcom/example/movies/fragment/ui/detail/DetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "args", "Lcom/example/movies/fragment/ui/detail/DetailFragmentArgs;", "getArgs", "()Lcom/example/movies/fragment/ui/detail/DetailFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "binding", "Lcom/example/movies/databinding/FragmentDetailBinding;", "getBinding", "()Lcom/example/movies/databinding/FragmentDetailBinding;", "detailBinding", "movieDetail", "Lcom/example/movies/database/movie/MovieData;", "saveList", "", "selectedTab", "", "timeRun", "", "viewModel", "Lcom/example/movies/fragment/viewmodel/detail/DetailMovieViewModel;", "getViewModel", "()Lcom/example/movies/fragment/viewmodel/detail/DetailMovieViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "animation", "", "collectError", "channel", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/movies/fragment/ui/ErrorView;", "label", "formatTextOrDefault", "value", "transform", "Lkotlin/Function1;", "defaultText", "observeErrorDetail", "observeErrorSave", "onClickSave", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "replaceView", "data", "setSelectedTab", "tabIndex", "selectedTextView", "Landroid/widget/TextView;", "unselectedTextView1", "unselectedTextView2", "selectedView", "unselectedView1", "unselectedView2", "setView", "updateSaveButton", "app_debug"})
public final class DetailFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.movies.databinding.FragmentDetailBinding detailBinding;
    private int selectedTab = 1;
    @org.jetbrains.annotations.NotNull()
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.example.movies.database.movie.MovieData movieDetail;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String timeRun = "";
    private boolean saveList = false;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public DetailFragment() {
        super();
    }
    
    private final com.example.movies.databinding.FragmentDetailBinding getBinding() {
        return null;
    }
    
    private final com.example.movies.fragment.ui.detail.DetailFragmentArgs getArgs() {
        return null;
    }
    
    private final com.example.movies.fragment.viewmodel.detail.DetailMovieViewModel getViewModel() {
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
    @android.annotation.SuppressLint(value = {"DefaultLocale", "Recycle"})
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void animation() {
    }
    
    private final void setView() {
    }
    
    private final java.lang.String formatTextOrDefault(java.lang.String value, kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String> transform, java.lang.String defaultText) {
        return null;
    }
    
    private final void updateSaveButton() {
    }
    
    private final void onClickSave() {
    }
    
    private final void replaceView(androidx.fragment.app.Fragment view, java.lang.String data) {
    }
    
    private final void setSelectedTab(int tabIndex, android.widget.TextView selectedTextView, android.widget.TextView unselectedTextView1, android.widget.TextView unselectedTextView2, android.view.View selectedView, android.view.View unselectedView1, android.view.View unselectedView2) {
    }
    
    private final void collectError(kotlinx.coroutines.flow.Flow<? extends com.example.movies.fragment.ui.ErrorView> channel, java.lang.String label) {
    }
    
    private final void observeErrorDetail(com.example.movies.fragment.viewmodel.detail.DetailMovieViewModel viewModel) {
    }
    
    private final void observeErrorSave(com.example.movies.fragment.viewmodel.detail.DetailMovieViewModel viewModel) {
    }
}