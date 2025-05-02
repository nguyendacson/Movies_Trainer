package com.example.movies.database.movie

data class DetailResponse(
    val runtime: Int,
    val account_states: DetailMovieData?
)

data class DetailMovieData(
    val watchlist: Boolean
)
