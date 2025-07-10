package com.example.movies.fragment.ui.menu

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.movies.R
import com.example.movies.database.movie.MovieData
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.String
import kotlin.Suppress

public class AllMovieNowPlayFragmentDirections private constructor() {
  private data class ActionAllMovieNowPlayFragmentToDetailFragment(
    public val movie: MovieData,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_allMovieNowPlayFragment_to_detailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(MovieData::class.java)) {
          result.putParcelable("movie", this.movie as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(MovieData::class.java)) {
          result.putSerializable("movie", this.movie as Serializable)
        } else {
          throw UnsupportedOperationException(MovieData::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  private data class ActionAllMovieNowPlayFragmentToFilterFragment(
    public val filterTitle: String = "Filter",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_allMovieNowPlayFragment_to_filterFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("filterTitle", this.filterTitle)
        return result
      }
  }

  public companion object {
    public fun actionAllMovieNowPlayFragmentToDetailFragment(movie: MovieData): NavDirections =
        ActionAllMovieNowPlayFragmentToDetailFragment(movie)

    public fun actionAllMovieNowPlayFragmentToNavGraphFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_allMovieNowPlayFragment_to_navGraphFragment)

    public fun actionAllMovieNowPlayFragmentToFilterFragment(filterTitle: String = "Filter"):
        NavDirections = ActionAllMovieNowPlayFragmentToFilterFragment(filterTitle)
  }
}
