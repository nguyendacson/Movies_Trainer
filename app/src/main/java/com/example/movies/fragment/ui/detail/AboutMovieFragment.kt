package com.example.movies.fragment.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.movies.R
import com.example.movies.databinding.FragmentAboutMovieBinding

class AboutMovieFragment : Fragment() {
    private lateinit var binding: FragmentAboutMovieBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataOverView = arguments?.getString("data")
        view.findViewById<TextView>(R.id.overviewMovie).text =
            if (dataOverView.isNullOrEmpty()) "No About Movie" else dataOverView
    }
}