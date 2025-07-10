package com.example.movies.fragment.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.movies.R

public class RegisterFragmentDirections private constructor() {
  public companion object {
    public fun RegisterConnectLogin(): NavDirections =
        ActionOnlyNavDirections(R.id.RegisterConnectLogin)

    public fun actionRegisterFragmentToSignUpFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_registerFragment_to_signUpFragment)
  }
}
