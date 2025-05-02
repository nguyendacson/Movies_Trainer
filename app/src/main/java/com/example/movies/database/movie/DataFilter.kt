package com.example.movies.database.movie

enum class SortDirection(val label: String) {
    ASCENDING("Ascending"),
    DESCENDING("Descending")
}

enum class SortField(val label: String) {
    EVALUATE("Vote Average"),
    YEAR("Year"),
    VOTE_COUNT("Vote Count")
}

data class SortState(
    val direction: SortDirection? = null,
    val field: SortField? = null,
)

