package com.example.movies.fragment.repository.auth

import com.example.movies.api.ApiAuth
import com.example.movies.database.authen.LoginData
import com.example.movies.database.authen.SignUpData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiAuth: ApiAuth
) {

    fun getUser(): Flow<Result<List<LoginData>>> = flow {
        try {
            emit(Result.success(apiAuth.getUsers()))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    suspend fun signUp(user: SignUpData): SignUpData? {
        return try {
            apiAuth.postUsers(user)
        } catch (e: Exception) {
            null
        }
    }
}