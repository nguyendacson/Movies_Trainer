package com.example.movies.fragment.viewmodel.detail;

import androidx.lifecycle.ViewModel;
import com.example.movies.fragment.repository.detail.DetailMovieRepository;
import com.example.movies.fragment.ui.ErrorView;
import com.example.movies.database.movie.DetailResponse;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/example/movies/fragment/viewmodel/detail/DetailMovieViewModel;", "Landroidx/lifecycle/ViewModel;", "detailMovieRepository", "Lcom/example/movies/fragment/repository/detail/DetailMovieRepository;", "(Lcom/example/movies/fragment/repository/detail/DetailMovieRepository;)V", "_detailMovie", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/movies/database/movie/DetailResponse;", "_errorDetail", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/movies/fragment/ui/ErrorView;", "_errorPostMovie", "detailMovie", "Lkotlinx/coroutines/flow/StateFlow;", "getDetailMovie", "()Lkotlinx/coroutines/flow/StateFlow;", "errorDetailMovie", "Lkotlinx/coroutines/flow/Flow;", "getErrorDetailMovie", "()Lkotlinx/coroutines/flow/Flow;", "errorPostMovie", "getErrorPostMovie", "", "idMovie", "", "postListMovie", "id", "", "save", "", "app_debug"})
public final class DetailMovieViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.movies.fragment.repository.detail.DetailMovieRepository detailMovieRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.movies.database.movie.DetailResponse> _detailMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.movies.database.movie.DetailResponse> detailMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.example.movies.fragment.ui.ErrorView> _errorDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.example.movies.fragment.ui.ErrorView> errorDetailMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.example.movies.fragment.ui.ErrorView> _errorPostMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.example.movies.fragment.ui.ErrorView> errorPostMovie = null;
    
    public DetailMovieViewModel(@org.jetbrains.annotations.NotNull()
    com.example.movies.fragment.repository.detail.DetailMovieRepository detailMovieRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.movies.database.movie.DetailResponse> getDetailMovie() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.movies.fragment.ui.ErrorView> getErrorDetailMovie() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.movies.fragment.ui.ErrorView> getErrorPostMovie() {
        return null;
    }
    
    public final void detailMovie(@org.jetbrains.annotations.NotNull()
    java.lang.String idMovie) {
    }
    
    public final void postListMovie(int id, boolean save) {
    }
}