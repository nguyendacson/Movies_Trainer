package com.example.movies.fragment.ui.auth

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.adapter.authen.AdapterProfile
import com.example.movies.database.authen.ProfileData
import com.example.movies.databinding.FragmentProfileBinding
import com.example.movies.datastore.DataStoreManagerAuth
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    @Inject
    lateinit var dataStoreManagerAuth: DataStoreManagerAuth

    @SuppressLint("CutPasteId", "MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.recyclerViewMyProfile.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataStoreManagerAuth = DataStoreManagerAuth(requireContext())
        val profileItems = listOf(
            ProfileData(R.drawable.btn_myprofile, "Profile"),
            ProfileData(R.drawable.btn_favourite, "Favorite"),
            ProfileData(R.drawable.btn_pay, "Payment Method"),
            ProfileData(R.drawable.btn_privacy, "Privacy Policy"),
            ProfileData(R.drawable.btn_setting, "Setting"),
            ProfileData(R.drawable.btn_help, "Help"),
            ProfileData(R.drawable.btn_logout, "Logout")
        )
        val adapterProfile = AdapterProfile(profileItems)
        adapterProfile.onClick = { item ->
            if (item.title == "Logout") {
                binding.dimBackground.visibility = View.VISIBLE
                binding.btnRequest.visibility = View.VISIBLE
            }
        }
        binding.recyclerViewMyProfile.adapter = adapterProfile
        lifecycleScope.launch {
            dataStoreManagerAuth.userName.collect { name ->
                binding.tvNameProfile.text = name
            }
        }
        lifecycleScope.launch {
            dataStoreManagerAuth.userAvatar.collect { avatar ->
                Glide.with(requireContext()).load(avatar).circleCrop().into(binding.btnImageProfile)
            }
        }

        binding.dimBackground.setOnClickListener {
            binding.dimBackground.visibility = View.GONE
            binding.btnRequest.visibility = View.GONE
        }

        binding.btnCancelLogout.setOnClickListener {
            binding.dimBackground.visibility = View.GONE
            binding.btnRequest.visibility = View.GONE
        }
        binding.btnYesLogout.setOnClickListener {
            binding.dimBackground.visibility = View.GONE
            binding.btnRequest.visibility = View.GONE
            lifecycleScope.launch {
                dataStoreManagerAuth.clearUserInfo()
            }
            val deepLink = Uri.parse("movies://register")
            val navController = requireActivity().findNavController(R.id.fragmentContainerView)
            navController.navigate(deepLink)
        }
    }
}