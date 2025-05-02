package com.example.movies.fragment.ui.auth

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.movies.R
import com.example.movies.databinding.FragmentLoginBinding
import com.example.movies.datastore.DataStoreManagerAuth
import com.example.movies.fragment.viewmodel.auth.AuthViewModel
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(), View.OnClickListener, View.OnFocusChangeListener,
    View.OnKeyListener {
    private lateinit var mBinding: FragmentLoginBinding
    private val viewModel: AuthViewModel by viewModels()

    @Inject
    lateinit var dataStoreManagerAuth: DataStoreManagerAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataStoreManagerAuth = DataStoreManagerAuth(requireContext())

        mBinding.btnBackLogin.setOnClickListener {
            findNavController().navigate(R.id.LoginConnectRegister)
        }

        mBinding.edtEmail.onFocusChangeListener = this
        mBinding.edtPassword.onFocusChangeListener = this

        mBinding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.LoginConnectSignUp)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loginResult.collect { success ->
                if (success) {
                    Toast.makeText(
                        requireContext(), getString(R.string.Success, "Login"), Toast.LENGTH_LONG
                    ).show()
                    val user = viewModel.currentUser.value
                    lifecycleScope.launch {
                        dataStoreManagerAuth.saveUserName(user?.name.orEmpty())
                        dataStoreManagerAuth.saveUserAvatar(user?.avatar.orEmpty())
                    }
                    findNavController().navigate(R.id.LoginConnect1)
                } else {
                    Toast.makeText(
                        requireContext(), getString(R.string.Fails, "Login"), Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        mBinding.btnLoginMain.setOnClickListener {
            val email = mBinding.edtEmail.text.toString().trim()
            val password = mBinding.edtPassword.text.toString().trim()

            var isValid = true
            if (email.isEmpty()) {
                setInputError(mBinding.tEmail, email, "Email")
                isValid = false
            }
            if (password.isEmpty()) {
                setInputError(mBinding.tPassword, password, "Password")
                isValid = false
            }
            if (isValid) {
                viewModel.login(email, password)
            }
        }

        mBinding.btnBackLogin.setOnClickListener {
            findNavController().navigate(R.id.LoginConnectRegister)
        }
    }

    private fun setInputError(inputLayout: TextInputLayout, input: String, title: String) {
        val errorMessage = when {
            input.isEmpty() -> getString(R.string.Required, title)
            input.length < 6 -> getString(R.string.Characters_longMessage, title)
            else -> null
        }

        inputLayout.apply {
            isErrorEnabled = errorMessage != null
            error = errorMessage
        }
    }

    override fun onClick(view: View?) {
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view != null) {
            when (view.id) {
                R.id.edtEmail -> {
                    if (hasFocus) {
                        mBinding.tEmail.isErrorEnabled = false
                    } else {
                        setInputError(mBinding.tEmail, mBinding.edtEmail.text.toString(), "Email")
                    }
                }

                R.id.edtPassword -> {
                    if (hasFocus) {
                        mBinding.tPassword.isErrorEnabled = false
                    } else {
                        setInputError(
                            mBinding.tPassword, mBinding.edtPassword.text.toString(), "Password"
                        )
                    }
                }
            }
        }
    }

    override fun onKey(view: View?, keyCode: Int, event: KeyEvent?): Boolean {
        return false
    }
}
