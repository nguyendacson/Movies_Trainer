package com.example.movies.adapter.movie

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.fragment.ui.toImageUrl
import com.example.movies.database.movie.MovieCategory
import com.example.movies.database.movie.MovieData


@Suppress("DEPRECATION")
class AdapterMovie(private val context: Context) :
    ListAdapter<MovieData, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<MovieData>() {
        override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem == newItem
        }
    }) {
    var onClick: ((movie: MovieData) -> Unit)? = null

    class TopRatedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val itemImage: ImageView = itemView.findViewById(R.id.itemImage)
        private val itemTitle: TextView = itemView.findViewById(R.id.itemTitle)

        @SuppressLint("SetTextI18n")
        fun binViewTopRate(item: MovieData) {
            Glide.with(itemImage.context).load(item.poster_path.toImageUrl()).into(itemImage)
            itemTitle.text = "${position + 1}"
        }
    }

    class NowPlayingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.itemImage)
        fun binViewNowPlay(item: MovieData) {
            Glide.with(itemImage.context).load(item.poster_path.toImageUrl()).into(itemImage)
        }
    }

    class AllNowPlayingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.itemImage)
        private val nameMovie: TextView = itemView.findViewById(R.id.nameMovie)
        private val voteCount: TextView = itemView.findViewById(R.id.voteCount)
        private val rateBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        fun binViewAllNowPlay(item: MovieData) {
            Glide.with(itemImage.context).load(item.poster_path.toImageUrl()).into(itemImage)
            nameMovie.text = item.title
            voteCount.text = item.vote_count.toString()
            rateBar.rating = (item.vote_average?.let { kotlin.math.round(it) }?.toFloat() ?: 0f) / 2
        }
    }

    class TrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.itemImage)

        fun binViewTrending(item: MovieData) {
            Glide.with(itemImage.context).load(item.poster_path.toImageUrl()).into(itemImage)
        }
    }

    class TrendingAllViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.itemImage)
        private val nameMovie: TextView = itemView.findViewById(R.id.nameMovie)
        private val voteCount: TextView = itemView.findViewById(R.id.voteCount)
        private val rateBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        fun binViewAllTrending(item: MovieData) {
            Glide.with(itemImage.context).load(item.poster_path.toImageUrl()).into(itemImage)
            nameMovie.text = item.title
            voteCount.text = item.vote_count.toString()
            rateBar.rating = (item.vote_average?.let { kotlin.math.round(it) }?.toFloat() ?: 0f) / 2
        }
    }

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.itemImage)
        private val nameMovie: TextView = itemView.findViewById(R.id.textNameMovie)
        private val numberStar: TextView = itemView.findViewById(R.id.numberStar)
        private val calenderMovie: TextView = itemView.findViewById(R.id.tvCalendar)

        fun binViewSearch(item: MovieData, context: Context) {
            Glide.with(itemImage.context).load(item.poster_path.toImageUrl()).into(itemImage)
            nameMovie.text = item.name
            numberStar.text = String.format(
                context.getString(R.string.formatStar), item.vote_average
            )
            calenderMovie.text = item.first_air_date?.substring(0, 4)
        }
    }

    class WatchListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage1: ImageView = itemView.findViewById(R.id.itemImageWatchList)
        private val nameMovie1: TextView = itemView.findViewById(R.id.textNameMovieWatchList)
        private val numberStar1: TextView = itemView.findViewById(R.id.numberStarWatchList)
        private val calenderMovie1: TextView = itemView.findViewById(R.id.tvCalendarWatchList)

        @SuppressLint("ClickableViewAccessibility")
        fun binViewWatchList(
            item: MovieData,
            context: Context,
        ) {
            Glide.with(itemImage1.context).load(item.poster_path.toImageUrl())
                .into(itemImage1)

            nameMovie1.text = item.title
            numberStar1.text =
                String.format(context.getString(R.string.formatStar), item.vote_average)
            calenderMovie1.text = item.first_air_date?.substring(0, 4)
        }
    }

    companion object {
        private const val VIEW_TYPE_TOP_RATED = 0
        private const val VIEW_TYPE_NOW_PLAYING = 1
        private const val VIEW_TYPE_ALL_NOW_PLAYING = 2
        private const val VIEW_TYPE_TRENDING = 3
        private const val VIEW_ALL_TYPE_TRENDING = 4
        private const val VIEW_TYPE_SEARCH = 5
        private const val VIEW_TYPE_WATCH_LIST = 6

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_TOP_RATED -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_recycler_toprated, parent, false)
                TopRatedViewHolder(view)
            }

            VIEW_TYPE_NOW_PLAYING -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_recycler_now_playing, parent, false)
                NowPlayingViewHolder(view)
            }

            VIEW_TYPE_ALL_NOW_PLAYING -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_all_nowplay_movie, parent, false)
                AllNowPlayingViewHolder(view)
            }

            VIEW_TYPE_TRENDING -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_recycler_now_playing, parent, false)
                TrendingViewHolder(view)
            }

            VIEW_ALL_TYPE_TRENDING -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_all_trending_movie, parent, false)
                TrendingAllViewHolder(view)
            }

            VIEW_TYPE_SEARCH -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
                SearchViewHolder(view)
            }

            VIEW_TYPE_WATCH_LIST -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_watch_list, parent, false)
                WatchListViewHolder(view)
            }

            else -> throw IllegalArgumentException(context.getString(R.string.null_screen))
        }
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie = getItem(position)
        when (holder) {
            is TopRatedViewHolder -> {
                holder.binViewTopRate(movie)
            }

            is NowPlayingViewHolder -> {
                holder.binViewNowPlay(movie)
            }

            is AllNowPlayingViewHolder -> {
                holder.binViewAllNowPlay(movie)
            }

            is TrendingViewHolder -> {
                holder.binViewTrending(movie)
            }

            is TrendingAllViewHolder -> {
                holder.binViewAllTrending(movie)
            }

            is SearchViewHolder -> {
                holder.binViewSearch(movie, holder.itemView.context)
            }

            is WatchListViewHolder -> {
                holder.binViewWatchList(movie, holder.itemView.context)
            }

        }
        holder.itemView.setOnClickListener {
            onClick?.invoke(movie)
        }
    }

    override fun getItemViewType(position: Int): Int = when (getItem(position).category) {
        MovieCategory.TOP_RATED -> VIEW_TYPE_TOP_RATED
        MovieCategory.NOW_PLAYING -> VIEW_TYPE_NOW_PLAYING
        MovieCategory.ALL_NOW_PLAYING -> VIEW_TYPE_ALL_NOW_PLAYING
        MovieCategory.TRENDING -> VIEW_TYPE_TRENDING
        MovieCategory.ALL_TRENDING -> VIEW_ALL_TYPE_TRENDING
        MovieCategory.SEARCH -> VIEW_TYPE_SEARCH
        MovieCategory.WATCHLIST -> VIEW_TYPE_WATCH_LIST
    }
}


