package com.example.movies.fragment.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.adapter.detail.AdapterMovieReview
import com.example.movies.api.ApiMovie
import com.example.movies.databinding.FragmentReviewMovieBinding
import com.example.movies.fragment.factory.detail.ReviewFactory
import com.example.movies.fragment.repository.detail.ReviewMovieRepository
import com.example.movies.fragment.ui.ErrorView
import com.example.movies.fragment.viewmodel.detail.ReviewMovieViewModel
import kotlinx.coroutines.launch

class ReviewMovieFragment : Fragment() {
    private lateinit var binding: FragmentReviewMovieBinding
    private var adapterReview: AdapterMovieReview? = null

    private val viewModel: ReviewMovieViewModel by viewModels {
        val application = requireActivity().application
        val repository = ReviewMovieRepository(ApiMovie.instance, application)
        ReviewFactory(repository,application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentReviewMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idMovie = arguments?.getString("data")

        if (idMovie != null) {
            viewModel.reviewMovie(idMovie)
        }

        setupRecyclerView()
        binding.buttonReload.setOnClickListener {
            observeLoading(viewModel)
            idMovie?.let {
                viewModel.reviewMovie(idMovie)
            }
            binding.constError.visibility = View.GONE
        }

        observeReview(viewModel)
        observeLoading(viewModel)
        observeError(viewModel)
    }

    private fun setupRecyclerView(){
        binding.constError.visibility = View.GONE
        binding.recyclerviewDetailReview.layoutManager = LinearLayoutManager(requireContext())
        adapterReview = AdapterMovieReview()
        binding.recyclerviewDetailReview.adapter = adapterReview
    }

    private fun observeReview(viewModel: ReviewMovieViewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.reviewMovie
                .collect { reviewList ->
                    adapterReview?.submitList(reviewList)
                }
        }
    }


    private fun observeLoading(viewModel: ReviewMovieViewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loading.collect { isLoading ->
                binding.loadingReview.isVisible = isLoading
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun observeError(viewModel: ReviewMovieViewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.errorReviewMovie.collect { error ->
                when (error) {
                    is ErrorView.NetworkError -> {
                        binding.tvMessage.visibility = View.VISIBLE
                        binding.tvMessage.text = "Error NetWork"
                        binding.constError.visibility = View.VISIBLE
                    }

                    is ErrorView.DataError -> {
                        binding.tvMessage.visibility = View.VISIBLE
                        binding.tvMessage.text = "No Data"
                        binding.constError.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}