package com.example.movies.fragment.ui

import com.example.movies.R

const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"

fun String?.toImageUrl(): Any {
    return if (isNullOrBlank()) {
        R.drawable.image_user_review
    } else {
        "$BASE_IMAGE_URL$this"
    }
}
