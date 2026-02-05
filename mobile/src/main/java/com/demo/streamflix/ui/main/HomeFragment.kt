package com.demo.streamflix.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.GridLayoutManager
import com.demo.streamflix.NavGraphDirections
import com.demo.streamflix.R
import com.demo.streamflix.databinding.FragmentHomeBinding
import com.demo.streamflix.ui.adapters.CategoryAdapter
import com.demo.streamflix.ui.adapters.ChannelAdapter
import com.demo.streamflix.util.Extensions.showSnackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var nacionalAdapter: ChannelAdapter
    private lateinit var actualidadAdapter: ChannelAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
        loadData()
    }

    private fun setupUI() {
        // Category RecyclerView
        categoryAdapter = CategoryAdapter { category ->
            // TODO: Implement category click navigation if needed
        }
        binding.rvCategories.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }

        // Channel RecyclerViews
        nacionalAdapter = ChannelAdapter { channel -> navigateToChannelDetail(channel) }
        binding.rvNacional.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = nacionalAdapter
        }

        actualidadAdapter = ChannelAdapter { channel -> navigateToChannelDetail(channel) }
        binding.rvActualidad.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = actualidadAdapter
        }

        // Bottom Navigation
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_tv -> true // Already on this screen
                R.id.navigation_cast -> {
                    // TODO: Implement cast functionality
                    true
                }
                R.id.navigation_profile -> {
                    findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
                    true
                }
                R.id.navigation_about -> {
                    findNavController().navigate(R.id.action_homeFragment_to_aboutFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.categories.collect { categories ->
                categoryAdapter.submitList(categories)
            }
        }

        lifecycleScope.launch {
            viewModel.channels.collect { channels ->
                nacionalAdapter.submitList(channels.filter { it.categoryId == 1 })
                actualidadAdapter.submitList(channels.filter { it.categoryId == 2 })
            }
        }

        lifecycleScope.launch {
            viewModel.isLoading.collect { isLoading ->
                // TODO: Show a loading indicator
            }
        }

        lifecycleScope.launch {
            viewModel.error.collect { error ->
                error?.let { showSnackbar(binding.root, it) }
            }
        }
    }

    private fun loadData() {
        viewModel.loadCategories()
        viewModel.loadChannels()
    }

    private fun navigateToChannelDetail(channel: com.demo.streamflix.data.model.Channel) {
        val action = NavGraphDirections.actionGlobalChannelDetailFragment(channel)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}