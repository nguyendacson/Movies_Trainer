package com.example.movies.adapter.authen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.database.authen.ProfileData


class AdapterProfile(
    private var items: List<ProfileData>
) : RecyclerView.Adapter<AdapterProfile.ProfileViewHolder>() {

    var onClick: ((ProfileData) -> Unit)? = null

    class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgIconProfile: ImageView = itemView.findViewById(R.id.imgIconProfile)
        val tvProfile: TextView = itemView.findViewById(R.id.tvProfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_my_profile, parent, false)
        return ProfileViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val item = items[position]
        holder.imgIconProfile.setImageResource(item.icon)
        holder.tvProfile.text = item.title

        holder.itemView.setOnClickListener {
            onClick?.invoke(item)
        }
    }
}