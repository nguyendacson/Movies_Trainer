package com.example.movies.fragment.ui.auth

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.movies.R

public class ProfileFragmentDirections private constructor() {
  public companion object {
    public fun ProfileConnectRegister(): NavDirections =
        ActionOnlyNavDirections(R.id.ProfileConnectRegister)
  }
}
