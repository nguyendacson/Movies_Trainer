package com.example.movies.database.movie

import com.google.gson.annotations.SerializedName

data class ReviewResponse(
    val results: List<ReviewMovieDetailData>
)

data class ReviewMovieDetailData(
    val author: String,
    @SerializedName("author_details") val authorDetails: AuthorDetails,
    val content: String
)

data class AuthorDetails(
    @SerializedName("avatar_path") val avatarPath: String?,
    @SerializedName("rating") val rating: Double?
)
