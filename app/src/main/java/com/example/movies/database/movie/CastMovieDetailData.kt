package com.example.movies.database.movie

data class CastResponse(
    val cast: List<CastMovieDetailData>
)

data class CastMovieDetailData(
    val name: String, val profile_path: String?
)