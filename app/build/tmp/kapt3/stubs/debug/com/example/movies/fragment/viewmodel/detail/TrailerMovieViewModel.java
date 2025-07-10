package com.example.movies.fragment.viewmodel.detail;

import androidx.lifecycle.ViewModel;
import com.example.movies.fragment.repository.detail.TrailerMovieRepository;
import com.example.movies.fragment.ui.ErrorView;
import com.example.movies.database.movie.Trailer;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/movies/fragment/viewmodel/detail/TrailerMovieViewModel;", "Landroidx/lifecycle/ViewModel;", "trailerMovieRepository", "Lcom/example/movies/fragment/repository/detail/TrailerMovieRepository;", "(Lcom/example/movies/fragment/repository/detail/TrailerMovieRepository;)V", "_errorTrailerMovie", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/movies/fragment/ui/ErrorView;", "_trailerMovie", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/movies/database/movie/Trailer;", "errorTrailerMovie", "getErrorTrailerMovie", "()Lkotlinx/coroutines/channels/Channel;", "trailerMovie", "Lkotlinx/coroutines/flow/StateFlow;", "getTrailerMovie", "()Lkotlinx/coroutines/flow/StateFlow;", "trailerMovies", "", "idMovie", "", "app_debug"})
public final class TrailerMovieViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.movies.fragment.repository.detail.TrailerMovieRepository trailerMovieRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.movies.database.movie.Trailer>> _trailerMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.movies.database.movie.Trailer>> trailerMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.example.movies.fragment.ui.ErrorView> _errorTrailerMovie = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<com.example.movies.fragment.ui.ErrorView> errorTrailerMovie = null;
    
    public TrailerMovieViewModel(@org.jetbrains.annotations.NotNull()
    com.example.movies.fragment.repository.detail.TrailerMovieRepository trailerMovieRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.movies.database.movie.Trailer>> getTrailerMovie() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.channels.Channel<com.example.movies.fragment.ui.ErrorView> getErrorTrailerMovie() {
        return null;
    }
    
    public final void trailerMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String idMovie) {
    }
}