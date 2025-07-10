package com.example.movies.fragment.viewmodel.detail;

import androidx.lifecycle.ViewModel;
import com.example.movies.fragment.repository.detail.CastMovieRepository;
import com.example.movies.fragment.ui.ErrorView;
import com.example.movies.database.movie.CastMovieDetailData;
import kotlinx.coroutines.flow.StateFlow;
import java.io.IOException;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/example/movies/fragment/viewmodel/detail/CastMovieViewModel;", "Landroidx/lifecycle/ViewModel;", "castMovieRepository", "Lcom/example/movies/fragment/repository/detail/CastMovieRepository;", "(Lcom/example/movies/fragment/repository/detail/CastMovieRepository;)V", "_castMovie", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/movies/database/movie/CastMovieDetailData;", "_errorCastMovie", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/movies/fragment/ui/ErrorView;", "_loading", "", "castMovie", "Lkotlinx/coroutines/flow/StateFlow;", "getCastMovie", "()Lkotlinx/coroutines/flow/StateFlow;", "errorCastMovie", "Lkotlinx/coroutines/flow/Flow;", "getErrorCastMovie", "()Lkotlinx/coroutines/flow/Flow;", "loading", "getLoading", "castMovies", "", "idMovie", "", "app_debug"})
public final class CastMovieViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.movies.fragment.repository.detail.CastMovieRepository castMovieRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.movies.database.movie.CastMovieDetailData>> _castMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.movies.database.movie.CastMovieDetailData>> castMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _loading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> loading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.example.movies.fragment.ui.ErrorView> _errorCastMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.example.movies.fragment.ui.ErrorView> errorCastMovie = null;
    
    public CastMovieViewModel(@org.jetbrains.annotations.NotNull()
    com.example.movies.fragment.repository.detail.CastMovieRepository castMovieRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.movies.database.movie.CastMovieDetailData>> getCastMovie() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.movies.fragment.ui.ErrorView> getErrorCastMovie() {
        return null;
    }
    
    public final void castMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String idMovie) {
    }
}