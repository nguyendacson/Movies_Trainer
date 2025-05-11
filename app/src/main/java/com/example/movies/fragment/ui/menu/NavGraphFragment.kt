package com.example.movies.fragment.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movies.R
import com.example.movies.adapter.movie.AdapterViewPager
import com.example.movies.database.movie.MovieData
import com.example.movies.databinding.FragmentNavGraphBinding
import com.example.movies.fragment.ui.auth.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

@Suppress("DEPRECATION")
class NavGraphFragment : Fragment() {
    private var navBinding: FragmentNavGraphBinding? = null
    private val binding get() = navBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        navBinding = FragmentNavGraphBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragments = listOf(
            HomeFragment(), SearchFragment(), WatchListFragment(), ProfileFragment()
        )

        val adapter = AdapterViewPager(this, fragments)
        binding.pagerMain.adapter = adapter
        binding.pagerMain.isUserInputEnabled = false

        when (val navView = binding.root.findViewById<View>(R.id.bottomNav)) {
            is BottomNavigationView -> {
                navView.setOnItemSelectedListener { item ->
                    handleNavigationItem(item.itemId)
                    true
                }
            }

            is NavigationView -> {
                navView.setNavigationItemSelectedListener { item ->
                    handleNavigationItem(item.itemId)
                    true
                }
            }
        }

        getDataHomeToDetail()
        getFilter()
    }

    private fun handleNavigationItem(itemId: Int) {
        when (itemId) {
            R.id.buttonHome -> binding.pagerMain.currentItem = 0
            R.id.buttonSearch -> binding.pagerMain.currentItem = 1
            R.id.buttonWatchList -> binding.pagerMain.currentItem = 2
            R.id.buttonProfile -> binding.pagerMain.currentItem = 3
        }
    }

    private fun getDataHomeToDetail() {
        requireActivity().supportFragmentManager.setFragmentResultListener(
            "keyMovie", viewLifecycleOwner
        ) { _, bundle ->
            val selectedMovie = bundle.getParcelable<MovieData>("movie")
            selectedMovie?.let { movie ->
                val action = NavGraphFragmentDirections.actionGlobalDetailFragment(movie)
                findNavController().navigate(action)
            }
        }
    }

    private fun getFilter() {
        requireActivity().supportFragmentManager.setFragmentResultListener(
            "keyScreenTitle", viewLifecycleOwner
        ) { _, bundle ->
            val title = bundle.getString("filterTitle") ?: "Filter"
            val action = NavGraphFragmentDirections.actionNavGraphFragmentToFilterFragment(title)
            findNavController().navigate(action)
        }
    }

    fun switchToSearchTab() {
        binding.pagerMain.currentItem = 1

        val bottomNavView = binding.root.findViewById<View>(R.id.bottomNav)
        if (bottomNavView is BottomNavigationView) {
            bottomNavView.selectedItemId = R.id.buttonSearch
        } else if (bottomNavView is NavigationView) {
            bottomNavView.setCheckedItem(R.id.buttonSearch)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        navBinding = null
    }
}
