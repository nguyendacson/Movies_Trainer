package com.example.movies.fragment.ui

sealed class ErrorView {
    data object DataError : ErrorView()
    data object NetworkError : ErrorView()
}
