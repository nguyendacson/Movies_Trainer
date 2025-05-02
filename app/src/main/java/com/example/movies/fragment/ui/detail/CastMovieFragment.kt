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
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies.adapter.detail.AdapterMovieCast
import com.example.movies.api.ApiMovie
import com.example.movies.databinding.FragmentCastMovieBinding
import com.example.movies.fragment.factory.detail.CastFactory
import com.example.movies.fragment.repository.detail.CastMovieRepository
import com.example.movies.fragment.ui.ErrorView
import com.example.movies.fragment.viewmodel.detail.CastMovieViewModel
import kotlinx.coroutines.launch

class CastMovieFragment : Fragment() {
    private lateinit var binding: FragmentCastMovieBinding
    private var adapterCast: AdapterMovieCast? = null

    private val viewModel: CastMovieViewModel by viewModels {
        val application = requireActivity().application
        val repository = CastMovieRepository(ApiMovie.instance, application)
        CastFactory(repository, application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCastMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idMovie = arguments?.getString("data")

        if (idMovie != null) {
            viewModel.castMovies(idMovie)
        }

        setupRecyclerView()

        binding.buttonReload.setOnClickListener {
            idMovie?.let {
                viewModel.castMovies(idMovie)
            }
            binding.constError.visibility = View.GONE
            observeLoading(viewModel)
        }

        observeCast(viewModel)
        observeLoading(viewModel)
        observeError(viewModel)
    }

    private fun setupRecyclerView() {
        binding.constError.visibility = View.GONE
        binding.recyclerViewMovieCast.layoutManager = GridLayoutManager(requireContext(), 2)
        adapterCast = AdapterMovieCast()
        binding.recyclerViewMovieCast.adapter = adapterCast
    }

    private fun observeCast(viewModel: CastMovieViewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.castMovie
                .collect { castList ->
                    adapterCast?.submitList(castList)
                }
        }
    }

    private fun observeLoading(viewModel: CastMovieViewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loading.collect { isLoading ->
                binding.loadingCast.isVisible = isLoading
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun observeError(viewModel: CastMovieViewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.errorCastMovie.collect { error ->
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

