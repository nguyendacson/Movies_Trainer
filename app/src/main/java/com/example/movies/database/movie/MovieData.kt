package com.example.movies.database.movie

import android.os.Parcel
import android.os.Parcelable

enum class MovieCategory { TOP_RATED, NOW_PLAYING,ALL_NOW_PLAYING, TRENDING,ALL_TRENDING, SEARCH, WATCHLIST}

data class  MovieData(
    var category: MovieCategory,
    var name: String?,
    var id: String?,
    var first_air_date: String?,
    var original_title: String?,
    var overview: String?,
    var popularity: Double?,
    var poster_path: String?,
    var backdrop_path: String?,
    var release_date: String?,
    var title: String?,
    var vote_count: Int?,
    var vote_average: Float?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        MovieCategory.valueOf(parcel.readString() ?: "TOP_RATED"),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Float::class.java.classLoader) as? Int,
        parcel.readValue(Float::class.java.classLoader) as? Float
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(category.name)
        parcel.writeString(name)
        parcel.writeString(id)
        parcel.writeString(first_air_date)
        parcel.writeString(original_title)
        parcel.writeString(overview)
        parcel.writeValue(popularity)
        parcel.writeString(poster_path)
        parcel.writeString(backdrop_path)
        parcel.writeString(release_date)
        parcel.writeString(title)
        parcel.writeValue(vote_count)
        parcel.writeValue(vote_average)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieData> {
        override fun createFromParcel(parcel: Parcel): MovieData {
            return MovieData(parcel)
        }

        override fun newArray(size: Int): Array<MovieData?> {
            return arrayOfNulls(size)
        }
    }
}



