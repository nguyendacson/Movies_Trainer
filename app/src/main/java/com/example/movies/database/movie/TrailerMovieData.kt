package com.example.movies.database.movie

import com.google.gson.annotations.SerializedName

data class TrailerResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("results") val results: List<Trailer>
)

data class Trailer(
    @SerializedName("key") val key: String,
    @SerializedName("type") val type: String,
    @SerializedName("official") val official: Boolean
)

data class MovieResponse(
    val results: List<MovieData>
)