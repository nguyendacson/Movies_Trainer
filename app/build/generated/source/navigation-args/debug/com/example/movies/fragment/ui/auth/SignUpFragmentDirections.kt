package com.example.movies.fragment.ui.auth

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.movies.R

public class SignUpFragmentDirections private constructor() {
  public companion object {
    public fun SignUpConnectRegister(): NavDirections =
        ActionOnlyNavDirections(R.id.SignUpConnectRegister)

    public fun SignUpConnectLogin(): NavDirections =
        ActionOnlyNavDirections(R.id.SignUpConnectLogin)
  }
}
