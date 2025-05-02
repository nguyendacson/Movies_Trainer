package com.example.movies.fragment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.movies.databinding.FragmentFilterBinding
import com.example.movies.fragment.viewmodel.FilterViewModel
import com.example.movies.database.movie.SortDirection
import com.example.movies.database.movie.SortField
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterFragment : Fragment() {
    private lateinit var binding: FragmentFilterBinding
    private val filterViewModel: FilterViewModel by activityViewModels()
    private val args: FilterFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setText()
        binding.imageBackSearchFilter.setOnClickListener {
            findNavController().navigateUp()
        }
        setupClicks()
    }


    private fun setText(){
        binding.valueAscending.text = SortDirection.ASCENDING.label
        binding.valueDescending.text = SortDirection.DESCENDING.label
        binding.valueYear.text = SortField.YEAR.label
        binding.valueEvaluate.text = SortField.EVALUATE.label
        binding.valueVoteCount.text = SortField.VOTE_COUNT.label
        binding.Title.text = args.filterTitle
        println("TITLE: ${args.filterTitle}")
    }
    private fun setupClicks() {
        binding.valueAscending.setOnClickListener {
            updateSortUI(binding.tickAscending, binding.tickDescending)
            filterViewModel.updateSortState(SortDirection.ASCENDING, getCurrentField())
        }

        binding.valueDescending.setOnClickListener {
            updateSortUI(binding.tickDescending, binding.tickAscending)
            filterViewModel.updateSortState(SortDirection.DESCENDING, getCurrentField())
        }

        binding.valueEvaluate.setOnClickListener {
            updateTypeUI(binding.tickEvaluate, binding.tickName, binding.tickYear)
            filterViewModel.updateSortState(getCurrentDirection(), SortField.EVALUATE)
        }
        binding.valueYear.setOnClickListener {
            updateTypeUI(binding.tickYear, binding.tickName, binding.tickEvaluate)
            filterViewModel.updateSortState(getCurrentDirection(), SortField.YEAR)
        }
        binding.valueVoteCount.setOnClickListener {
            updateTypeUI(binding.tickName, binding.tickYear, binding.tickEvaluate)
            filterViewModel.updateSortState(getCurrentDirection(), SortField.VOTE_COUNT)
        }
    }


    private fun updateSortUI(show: View, hide: View) {
        show.visibility = View.VISIBLE
        hide.visibility = View.GONE
    }

    private fun updateTypeUI(show: View, hide1: View, hide2: View) {
        show.visibility = View.VISIBLE
        hide1.visibility = View.GONE
        hide2.visibility = View.GONE
    }

    private fun getCurrentDirection(): SortDirection? {
        return when {
            binding.tickAscending.visibility == View.VISIBLE -> SortDirection.ASCENDING
            binding.tickDescending.visibility == View.VISIBLE -> SortDirection.DESCENDING
            else -> null
        }
    }

    private fun getCurrentField(): SortField? {
        return when {
            binding.tickEvaluate.visibility == View.VISIBLE -> SortField.EVALUATE
            binding.tickYear.visibility == View.VISIBLE -> SortField.YEAR
            binding.tickName.visibility == View.VISIBLE -> SortField.VOTE_COUNT
            else -> null
        }
    }
}

