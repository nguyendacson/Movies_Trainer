package com.example.movies.fragment.ui.auth

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.movies.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun LoginConnectSignUp(): NavDirections =
        ActionOnlyNavDirections(R.id.LoginConnectSignUp)

    public fun LoginConnectProfile(): NavDirections =
        ActionOnlyNavDirections(R.id.LoginConnectProfile)

    public fun LoginConnectRegister(): NavDirections =
        ActionOnlyNavDirections(R.id.LoginConnectRegister)

    public fun LoginConnect1(): NavDirections = ActionOnlyNavDirections(R.id.LoginConnect1)
  }
}
