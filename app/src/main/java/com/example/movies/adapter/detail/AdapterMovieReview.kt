package com.example.movies.adapter.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.fragment.ui.toImageUrl
import com.example.movies.database.movie.ReviewMovieDetailData


class AdapterMovieReview :
    ListAdapter<ReviewMovieDetailData, AdapterMovieReview.ReviewHolder>(
        object : DiffUtil.ItemCallback<ReviewMovieDetailData>() {
            override fun areItemsTheSame(
                oldItem: ReviewMovieDetailData,
                newItem: ReviewMovieDetailData
            ): Boolean {
                return oldItem.author == newItem.author
            }

            override fun areContentsTheSame(
                oldItem: ReviewMovieDetailData,
                newItem: ReviewMovieDetailData
            ): Boolean {
                return oldItem == newItem
            }

        }) {

    class ReviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageUser: ImageView = itemView.findViewById(R.id.imageUserReview)
        private val nameUser: TextView = itemView.findViewById(R.id.nameUserReview)
        private val contentUser: TextView = itemView.findViewById(R.id.contentUserReview)
        private val pointUser: TextView = itemView.findViewById(R.id.pointUser)

        fun binView(item: ReviewMovieDetailData, context: Context) {
            Glide.with(imageUser.context)
                .load(item.authorDetails.avatarPath.toImageUrl())
                .error(R.drawable.image_user_review)
                .circleCrop()
                .into(imageUser)
            nameUser.text = item.author
            pointUser.text =
                item.authorDetails.rating?.toString() ?: context.getString(R.string.pointAuthor)
            contentUser.text = item.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_review_movie, parent, false)
        return ReviewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewHolder, position: Int) {
        holder.binView(getItem(position), holder.itemView.context)
    }
}
