package com.example.movies.fragment.ui.auth

import android.os.Bundle
import android.util.Patterns
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
import com.example.movies.databinding.FragmentSignUpBinding
import com.example.movies.fragment.viewmodel.auth.AuthViewModel
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class SignUpFragment : Fragment(), View.OnClickListener, View.OnFocusChangeListener,
    View.OnKeyListener {
    private lateinit var mBinding: FragmentSignUpBinding
    private var fullName: String = ""
    private var email: String = ""
    private var password: String = ""
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSignUpBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()

        mBinding.tvLogin.setOnClickListener {
            findNavController().navigate(R.id.SignUpConnectLogin)
        }
        mBinding.btnBackSignUp.setOnClickListener {
            findNavController().navigate(R.id.SignUpConnectRegister)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.signUpResult.collect { success ->
                if (success) {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.Success, "Sign Up"),
                        Toast.LENGTH_LONG
                    ).show()
                    findNavController().navigate(R.id.SignUpConnectLogin)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.signUpError.collect { errorMessage ->
                if (errorMessage != null) {
                    Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
                }
            }
        }

        mBinding.btnSignUp.setOnClickListener {
            fullName = mBinding.edtFullName.text.toString().trim()
            email = mBinding.edtEmail.text.toString().trim()
            password = mBinding.edtPassword.text.toString().trim()
            val inValid =
                validateFullName() && validateEmail() && validatePassWord() && validatePhoneNumber(
                    mBinding.tNumberPhone, mBinding.edtNumberPhone.text.toString()
                ) && validateDate(
                    mBinding.tDate, mBinding.edtDate.text.toString()
                )
            if (!inValid) return@setOnClickListener

            viewModel.signUp(fullName, email, password)
        }
    }

    private fun setView() {
        mBinding.edtFullName.onFocusChangeListener = this
        mBinding.edtEmail.onFocusChangeListener = this
        mBinding.edtPassword.onFocusChangeListener = this
        mBinding.edtNumberPhone.onFocusChangeListener = this
        mBinding.edtDate.onFocusChangeListener = this
    }

    private fun setInputError(inputLayout: TextInputLayout, input: String, title: String): Boolean {
        val errorMessage = when {
            input.isEmpty() -> getString(R.string.Required, title)
            input.length < 6 -> getString(R.string.Characters_longMessage, title)
            else -> null
        }

        inputLayout.apply {
            isErrorEnabled = errorMessage != null
            error = errorMessage
        }

        return errorMessage == null
    }

    private fun validateFullName(): Boolean {
        val fullName = mBinding.edtFullName.text.toString()
        return setInputError(mBinding.tFullName, fullName, "Name")
    }

    private fun validateEmail(): Boolean {
        val email = mBinding.edtEmail.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(
                requireContext(),
                getString(R.string.Fails, "Email address is invalid"),
                Toast.LENGTH_LONG
            ).show()
        }

        return setInputError(mBinding.tEmail, email, "Email")
    }

    private fun validatePassWord(): Boolean {
        val password = mBinding.edtPassword.text.toString()
        return setInputError(mBinding.tPassword, password, "Password")
    }

    private fun validatePhoneNumber(inputLayout: TextInputLayout, input: String): Boolean {
        val errorMessage = when {
            input.isEmpty() -> getString(R.string.Required, "Number phone")
            input.length != 10 -> getString(R.string.Characters_long)
            else -> null
        }

        inputLayout.apply {
            isErrorEnabled = errorMessage != null
            error = errorMessage
        }
        return errorMessage == null
    }

    private fun validateDate(inputLayout: TextInputLayout, input: String): Boolean {
        val inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val errorMessage = when {
            input.isEmpty() -> getString(R.string.Required, "Date")
            !isValidDate(input, inputFormatter) -> getString(R.string.Invalid_date)
            else -> null
        }
        inputLayout.apply {
            isErrorEnabled = errorMessage != null
            error = errorMessage
        }
        return errorMessage == null
    }

    private fun isValidDate(date: String, formatter: DateTimeFormatter): Boolean {
        return try {
            LocalDate.parse(date, formatter)
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun onClick(view: View?) {
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view != null) {
            when (view.id) {
                R.id.edtFullName -> {
                    if (hasFocus) {
                        mBinding.tFullName.isErrorEnabled = false
                    } else {
                        validateFullName()
                    }
                }

                R.id.edtEmail -> {
                    if (hasFocus) {
                        mBinding.tEmail.isErrorEnabled = false
                    } else {
                        setInputError(
                            mBinding.tEmail, mBinding.edtEmail.text.toString(), "Email"
                        )
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

                R.id.edtNumberPhone -> {
                    if (hasFocus) {
                        mBinding.tNumberPhone.isErrorEnabled = false
                    } else {
                        validatePhoneNumber(
                            mBinding.tNumberPhone, mBinding.edtNumberPhone.text.toString()
                        )
                    }
                }

                R.id.edtDate -> {
                    if (hasFocus) {
                        mBinding.tDate.isErrorEnabled = false
                    } else {
                        validateDate(
                            mBinding.tDate, mBinding.edtDate.text.toString()
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

