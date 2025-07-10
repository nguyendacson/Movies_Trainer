package com.example.movies.fragment.ui.detail

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.movies.R

public class DetailFragmentDirections private constructor() {
  public companion object {
    public fun actionDetailFragmentToNavGraphFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detailFragment_to_navGraphFragment)

    public fun actionDetailFragmentToTrailerFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detailFragment_to_trailerFragment)
  }
}
