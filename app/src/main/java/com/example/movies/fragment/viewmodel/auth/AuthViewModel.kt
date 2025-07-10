package com.example.movies.fragment.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.fragment.repository.auth.AuthRepository
import com.example.movies.database.authen.LoginData
import com.example.movies.database.authen.SignUpData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {

    private val _users = MutableStateFlow<List<LoginData>>(emptyList())
    private val _currentUser = MutableStateFlow<LoginData?>(null)

    val currentUser = _currentUser.asStateFlow()

//    private val _loginResult = Channel<Boolean>()
//    val loginResult = _loginResult.receiveAsFlow()

    private val _loginResult = MutableSharedFlow<Boolean>(replay = 1)
    val loginResult: SharedFlow<Boolean> = _loginResult

    private val _signUpResult = Channel<Boolean>()
    val signUpResult = _signUpResult.receiveAsFlow()

    private val _signUpError = Channel<String?>()
    val signUpError = _signUpError.receiveAsFlow()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            authRepository.getUser().collect { result ->
                result.onSuccess {
                    _users.value = it
                    println("Users: $it")
                }.onFailure {
                    _users.value = emptyList()
                }
            }
        }
    }



//    fun login(email: String, password: String) {
//        val user = _users.value.find { it.email == email && it.password == password }
//        _currentUser.value = user
//        viewModelScope.launch {
//            _loginResult.send(user != null)
//        }
//    }

    fun login(email: String, password: String) {
        val user = _users.value.find { it.email == email && it.password == password }
        _currentUser.value = user
        viewModelScope.launch {
            _loginResult.emit(user != null)
        }
    }

    fun signUp(fullName: String, email: String, password: String) {
        viewModelScope.launch {
            val existingUser = _users.value.find { it.email == email }

            if (existingUser != null) {
                _signUpResult.send(false)
                _signUpError.send("Email already exists")
            } else {
                val defaultAVT =
                    "https://fastly.picsum.photos/id/309/800/800.jpg?hmac=U2W9h89OVgIP8Mi5iFZl-w8iIcqvZ-XOGFyxDkNCXoI"
                val newUser = SignUpData(fullName, email, password, defaultAVT)
                val response = authRepository.signUp(newUser)

                if (response != null) {
                    _signUpResult.send(true)
                    _signUpError.send(null)
                    fetchUsers()
                } else {
                    _signUpResult.send(false)
                    _signUpError.send("Sign up failed. Please try again.")
                }
            }
        }
    }
}


