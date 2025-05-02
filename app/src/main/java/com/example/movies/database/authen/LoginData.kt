package com.example.movies.database.authen

data class LoginData(
    var name: String,
    var email: String,
    var password: String,
    var role: String,
    var avatar: String? = null
)
