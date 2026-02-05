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
import com.demo.streamflix.R
import com.demo.streamflix.databinding.FragmentHomeBinding
import com.demo.streamflix.ui.adapters.CategoryAdapter
import com.demo.streamflix.ui.adapters.ChannelAdapter
import com.demo.streamflix.extensions.showSnackbar
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
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.layoutManager = layoutManager

        categoryAdapter = CategoryAdapter { category ->
            val bundle = Bundle().apply {
                putLong("categoryId", category.id)
                putString("categoryName", category.name)
            }
            try {
                findNavController().navigate(R.id.action_homeFragment_to_categoryFragment, bundle)
            } catch (e: Exception) {
                showSnackbar(binding.root, "Categoría no disponible temporalmente")
            }
        }
        binding.rvCategories.adapter = categoryAdapter

        // Channel RecyclerViews
        nacionalAdapter = ChannelAdapter { channel ->
            navigateToChannelDetail(channel)
        }
        binding.rvNacional.apply {
            // Remove o layoutManager do XML e configura no código
            this.layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = nacionalAdapter
        }

        actualidadAdapter = ChannelAdapter { channel ->
            navigateToChannelDetail(channel)
        }
        binding.rvActualidad.apply {
            this.layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = actualidadAdapter
        }
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.categories.collect { categories ->
                // Filtrar apenas categorias ativas
                val activeCategories = categories.filter { it.isActive }
                categoryAdapter.submitList(activeCategories)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.nacionalChannels.collect { channels ->
                nacionalAdapter.submitList(channels)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.actualidadChannels.collect { channels ->
                actualidadAdapter.submitList(channels)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isLoading.collect { isLoading ->
                // Controle de visibilidade durante carregamento
                if (isLoading) {
                    binding.rvCategories.visibility = View.INVISIBLE
                    binding.tvNacional.visibility = View.INVISIBLE
                    binding.rvNacional.visibility = View.INVISIBLE
                    binding.tvActualidad.visibility = View.INVISIBLE
                    binding.rvActualidad.visibility = View.INVISIBLE
                } else {
                    binding.rvCategories.visibility = View.VISIBLE
                    binding.tvNacional.visibility = View.VISIBLE
                    binding.rvNacional.visibility = View.VISIBLE
                    binding.tvActualidad.visibility = View.VISIBLE
                    binding.rvActualidad.visibility = View.VISIBLE
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.error.collect { error ->
                error?.let { showSnackbar(binding.root, it) }
            }
        }
    }

    private fun loadData() {
        viewModel.loadCategories()
        viewModel.loadNacionalChannels()
        viewModel.loadActualidadChannels()
    }

    private fun navigateToChannelDetail(channel: com.demo.streamflix.data.local.entity.ChannelEntity) {
        val bundle = Bundle().apply {
            putLong("channelId", channel.id)
            putString("channelName", channel.name)
            putString("channelLogo", channel.logoUrl)
            putString("channelStreamUrl", channel.streamUrl)
            putString("channelDescription", channel.description)
            putBoolean("channelIsHd", channel.isHd)
            putInt("channelNumber", channel.number)
        }

        findNavController().navigate(R.id.action_global_channelDetailFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}