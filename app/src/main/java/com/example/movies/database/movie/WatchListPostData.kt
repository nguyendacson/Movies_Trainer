package com.example.movies.database.movie

data class WatchListPostData(
    val media_type:String ,
    val media_id: Int,
    val watchlist: Boolean
)
