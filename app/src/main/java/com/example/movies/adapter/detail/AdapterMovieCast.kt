package com.example.movies.adapter.detail

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
import com.example.movies.database.movie.CastMovieDetailData
import com.example.movies.fragment.ui.toImageUrl

class AdapterMovieCast : ListAdapter<CastMovieDetailData, AdapterMovieCast.CastHolder>(object :
    DiffUtil.ItemCallback<CastMovieDetailData>() {
    override fun areItemsTheSame(
        oldItem: CastMovieDetailData,
        newItem: CastMovieDetailData
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: CastMovieDetailData,
        newItem: CastMovieDetailData
    ): Boolean {
        return oldItem == newItem
    }
}) {

    class CastHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageCast: ImageView = itemView.findViewById(R.id.imageUserCast)
        private val nameCast: TextView = itemView.findViewById(R.id.nameUserCast)

        fun binView(item: CastMovieDetailData) {
            nameCast.text = item.name
            Glide.with(imageCast.context)
                .load(item.profile_path.toImageUrl())
                .error(R.drawable.img_user)
                .circleCrop()
                .into(imageCast)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cast_movie, parent, false)
        return CastHolder(view)
    }

    override fun onBindViewHolder(holder: CastHolder, position: Int) {
        holder.binView(getItem(position))
    }
}































