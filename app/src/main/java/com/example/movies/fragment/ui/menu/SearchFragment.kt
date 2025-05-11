package com.example.movies.fragment.ui.menu

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies.R
import com.example.movies.adapter.movie.AdapterMovie
import com.example.movies.api.ApiMovie
import com.example.movies.database.movie.MovieCategory
import com.example.movies.database.movie.MovieData
import com.example.movies.database.movie.SortDirection
import com.example.movies.database.movie.SortField
import com.example.movies.databinding.FragmentSearchBinding
import com.example.movies.fragment.factory.menu.SearchFactory
import com.example.movies.fragment.repository.menu.SearchMovieRepository
import com.example.movies.fragment.viewmodel.FilterViewModel
import com.example.movies.fragment.viewmodel.menu.SearchViewModel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import java.time.LocalDate

class SearchFragment : Fragment() {
    private var searchBinding: FragmentSearchBinding? = null
    private val binding get() = searchBinding!!
    private var searchAdapter: AdapterMovie? = null
    private val filterViewModel: FilterViewModel by activityViewModels()

    private val viewModel: SearchViewModel by viewModels {
        val application = requireActivity().application
        val repository = SearchMovieRepository(ApiMovie.instance)
        SearchFactory(repository, application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        searchBinding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.edtSearch.requestFocus()
        val imm =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.edtSearch, InputMethodManager.SHOW_IMPLICIT)

        val spanCount = if (isTablet()) 2 else 1
        binding.mainItemSearch.layoutManager = GridLayoutManager(requireContext(), spanCount)
        binding.mainItemSearch.setHasFixedSize(true)

        if (searchAdapter == null) {
            searchAdapter = AdapterMovie(requireContext())
        }

        binding.mainItemSearch.adapter = searchAdapter

        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            @SuppressLint("ClickableViewAccessibility")
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim()
                val drawables = binding.edtSearch.compoundDrawablesRelative

                if (query.isNotEmpty()) {
                    val clearIcon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.btn_clear)
                    binding.edtSearch.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        drawables[0], drawables[1], clearIcon, drawables[3]
                    )
                    viewModel.searchMovies(query)
                } else {
                    binding.edtSearch.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        drawables[0], drawables[1], null, drawables[3]
                    )
                    searchAdapter?.submitList(emptyList())
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.edtSearch.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val editText = v as EditText
                val drawableRight = editText.compoundDrawables[2]

                if (drawableRight != null) {
                    val drawableWidth = drawableRight.bounds.width()
                    val touchX = event.x
                    val viewWidth = editText.width
                    val paddingEnd = editText.paddingEnd

                    if (touchX >= viewWidth - paddingEnd - drawableWidth) {
                        editText.text?.clear()
                        return@setOnTouchListener true
                    }
                }
            }
            false
        }

        binding.edtSearch.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                val im =
                    requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                im.hideSoftInputFromWindow(binding.edtSearch.windowToken, 0)
                true
            } else {
                false
            }
        }

        observeAndSortSearch(viewModel, filterViewModel)
        onClickItem()

        binding.btnFilter.setOnClickListener {
            sentTitleFilter()
        }
    }

    private fun isTablet(): Boolean {
        val displayMetrics = resources.displayMetrics
        val widthDp = displayMetrics.widthPixels / displayMetrics.density
        return widthDp >= 600
    }

    private fun onClickItem() {
        searchAdapter?.onClick = { movie ->
            sentDataNavGraph(movie)
        }
    }

    private fun observeAndSortSearch(
        searchViewModel: SearchViewModel, filterViewModel: FilterViewModel
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            combine(
                searchViewModel.searchMovies, filterViewModel.sortState
            ) { searchList, sortState ->
                val mappedList = searchList?.map {
                    it.copy(
                        name = it.name ?: it.title,
                        first_air_date = it.first_air_date ?: LocalDate.now().year.toString(),
                        category = MovieCategory.SEARCH
                    )
                }?.sortedByDescending { it.name?.lowercase() } ?: emptyList()
                val sortedList = when (sortState.field) {
                    SortField.EVALUATE -> {
                        if (sortState.direction == SortDirection.ASCENDING) mappedList.sortedBy { it.vote_average }
                        else mappedList.sortedByDescending { it.vote_average }
                    }

                    SortField.YEAR -> {
                        if (sortState.direction == SortDirection.ASCENDING) mappedList.sortedBy {
                            it.first_air_date?.toIntOrNull() ?: 0
                        }
                        else mappedList.sortedByDescending { it.first_air_date?.toIntOrNull() ?: 0 }
                    }

                    SortField.VOTE_COUNT -> {
                        if (sortState.direction == SortDirection.ASCENDING) mappedList.sortedBy { it.vote_count }
                        else mappedList.sortedByDescending { it.vote_count }
                    }

                    else -> mappedList
                }
                sortedList
            }.collect { updatedMovies ->
                searchAdapter?.submitList(updatedMovies) {
                    binding.mainItemSearch.scrollToPosition(0)
                }
                binding.hintConstraint.visibility =
                    if (updatedMovies.isEmpty()) View.VISIBLE else View.GONE

            }
        }
    }

    private fun sentDataNavGraph(data: MovieData) {
        val bundle = Bundle().apply {
            putParcelable("movie", data)
        }
        requireActivity().supportFragmentManager.setFragmentResult("keyMovie", bundle)
    }

    private fun sentTitleFilter() {
        val bundle = Bundle().apply {
            putString("filterTitle", "Search Filter")
        }
        requireActivity().supportFragmentManager.setFragmentResult("keyScreenTitle", bundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        searchBinding = null
    }
}
