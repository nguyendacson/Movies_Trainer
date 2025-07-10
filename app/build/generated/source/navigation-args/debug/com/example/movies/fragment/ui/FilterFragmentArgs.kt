package com.example.movies.fragment.ui

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class FilterFragmentArgs(
  public val filterTitle: String = "Filter",
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("filterTitle", this.filterTitle)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("filterTitle", this.filterTitle)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): FilterFragmentArgs {
      bundle.setClassLoader(FilterFragmentArgs::class.java.classLoader)
      val __filterTitle : String?
      if (bundle.containsKey("filterTitle")) {
        __filterTitle = bundle.getString("filterTitle")
        if (__filterTitle == null) {
          throw IllegalArgumentException("Argument \"filterTitle\" is marked as non-null but was passed a null value.")
        }
      } else {
        __filterTitle = "Filter"
      }
      return FilterFragmentArgs(__filterTitle)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): FilterFragmentArgs {
      val __filterTitle : String?
      if (savedStateHandle.contains("filterTitle")) {
        __filterTitle = savedStateHandle["filterTitle"]
        if (__filterTitle == null) {
          throw IllegalArgumentException("Argument \"filterTitle\" is marked as non-null but was passed a null value")
        }
      } else {
        __filterTitle = "Filter"
      }
      return FilterFragmentArgs(__filterTitle)
    }
  }
}
