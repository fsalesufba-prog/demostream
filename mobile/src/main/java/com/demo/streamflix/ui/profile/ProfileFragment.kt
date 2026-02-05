package com.demo.streamflix.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.demo.streamflix.R
import com.demo.streamflix.databinding.FragmentProfileBinding
import com.demo.streamflix.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
        loadUserData()
    }

    private fun setupUI() {
        // Setup back button
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        // Setup buttons
        binding.btnUpdate.setOnClickListener {
            // TODO: Implement edit profile navigation
            showToast("Funcionalidad no implementada")
        }

        binding.btnChangePassword.setOnClickListener {
            // TODO: Implement change password navigation
            showToast("Funcionalidad no implementada")
        }

        binding.btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.userProfile.collect { user ->
                user?.let {
                    binding.tvName.text = it.name

                    binding.itemEmail.ivIcon.setImageResource(R.drawable.ic_email)
                    binding.itemEmail.tvInfo.text = it.email

                    binding.itemPhone.ivIcon.setImageResource(R.drawable.ic_phone)
                    binding.itemPhone.tvInfo.text = it.phone ?: "N/A"
                }
            }
        }

        lifecycleScope.launch {
            viewModel.isLoading.collect { isLoading ->
                // TODO: Show a loading indicator
            }
        }

        lifecycleScope.launch {
            viewModel.error.collect { error ->
                error?.let {
                    showToast(it)
                }
            }
        }
    }

    private fun loadUserData() {
        viewModel.loadUserProfile()
    }

    private fun logout() {
        viewModel.logout()
        // Navigate to the login screen by restarting the navigation graph
        findNavController().navigate(R.id.action_global_splashFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}