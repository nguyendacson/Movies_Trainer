package com.example.movies.fragment.ui.detail

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.movies.database.movie.MovieData
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class DetailFragmentArgs(
  public val movie: MovieData,
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(MovieData::class.java)) {
      result.set("movie", this.movie as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(MovieData::class.java)) {
      result.set("movie", this.movie as Serializable)
    } else {
      throw UnsupportedOperationException(MovieData::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): DetailFragmentArgs {
      bundle.setClassLoader(DetailFragmentArgs::class.java.classLoader)
      val __movie : MovieData?
      if (bundle.containsKey("movie")) {
        if (Parcelable::class.java.isAssignableFrom(MovieData::class.java) ||
            Serializable::class.java.isAssignableFrom(MovieData::class.java)) {
          __movie = bundle.get("movie") as MovieData?
        } else {
          throw UnsupportedOperationException(MovieData::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__movie == null) {
          throw IllegalArgumentException("Argument \"movie\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"movie\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__movie)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetailFragmentArgs {
      val __movie : MovieData?
      if (savedStateHandle.contains("movie")) {
        if (Parcelable::class.java.isAssignableFrom(MovieData::class.java) ||
            Serializable::class.java.isAssignableFrom(MovieData::class.java)) {
          __movie = savedStateHandle.get<MovieData?>("movie")
        } else {
          throw UnsupportedOperationException(MovieData::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__movie == null) {
          throw IllegalArgumentException("Argument \"movie\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"movie\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__movie)
    }
  }
}
