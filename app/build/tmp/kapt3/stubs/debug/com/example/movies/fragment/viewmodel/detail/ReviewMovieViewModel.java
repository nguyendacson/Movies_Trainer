package com.example.movies.fragment.viewmodel.detail;

import androidx.lifecycle.ViewModel;
import com.example.movies.fragment.repository.detail.ReviewMovieRepository;
import com.example.movies.fragment.ui.ErrorView;
import com.example.movies.database.movie.ReviewMovieDetailData;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/movies/fragment/viewmodel/detail/ReviewMovieViewModel;", "Landroidx/lifecycle/ViewModel;", "reviewMovieRepository", "Lcom/example/movies/fragment/repository/detail/ReviewMovieRepository;", "(Lcom/example/movies/fragment/repository/detail/ReviewMovieRepository;)V", "_errorReviewMovie", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/movies/fragment/ui/ErrorView;", "_loading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_reviewMovie", "", "Lcom/example/movies/database/movie/ReviewMovieDetailData;", "errorReviewMovie", "Lkotlinx/coroutines/flow/Flow;", "getErrorReviewMovie", "()Lkotlinx/coroutines/flow/Flow;", "loading", "Lkotlinx/coroutines/flow/StateFlow;", "getLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "reviewMovie", "getReviewMovie", "", "idMovie", "", "app_debug"})
public final class ReviewMovieViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.movies.fragment.repository.detail.ReviewMovieRepository reviewMovieRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.movies.database.movie.ReviewMovieDetailData>> _reviewMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.movies.database.movie.ReviewMovieDetailData>> reviewMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _loading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> loading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.example.movies.fragment.ui.ErrorView> _errorReviewMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.example.movies.fragment.ui.ErrorView> errorReviewMovie = null;
    
    public ReviewMovieViewModel(@org.jetbrains.annotations.NotNull()
    com.example.movies.fragment.repository.detail.ReviewMovieRepository reviewMovieRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.movies.database.movie.ReviewMovieDetailData>> getReviewMovie() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.movies.fragment.ui.ErrorView> getErrorReviewMovie() {
        return null;
    }
    
    public final void reviewMovie(@org.jetbrains.annotations.NotNull()
    java.lang.String idMovie) {
    }
}