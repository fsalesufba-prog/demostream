package com.demo.streamflix.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.streamflix.NavGraphDirections
import com.demo.streamflix.R
import com.demo.streamflix.databinding.FragmentSearchBinding
import com.demo.streamflix.ui.adapters.ChannelAdapter
import com.demo.streamflix.util.Extensions.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchViewModel by viewModels()

    private lateinit var channelAdapter: ChannelAdapter
    private var searchJob: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
    }

    private fun setupUI() {
        // Setup back button
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        // Setup search adapter
        channelAdapter = ChannelAdapter { channel ->
            navigateToChannelDetail(channel)
        }
        binding.rvSearchResults.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = channelAdapter
        }

        // Setup search functionality
        binding.etSearch.apply {
            setOnEditorActionListener { _, _, _ ->
                performSearch()
                hideKeyboard()
                true
            }

            doAfterTextChanged { editable ->
                editable?.let {
                    if (it.length >= 2) {
                        debounceSearch(it.toString())
                    } else {
                        clearSearchResults()
                    }
                }
            }
        }
    }

    private fun debounceSearch(query: String) {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            delay(500) // 500ms debounce
            viewModel.searchChannels(query)
        }
    }

    private fun performSearch() {
        val query = binding.etSearch.text.toString().trim()
        if (query.isNotEmpty()) {
            hideKeyboard()
            viewModel.searchChannels(query)
        }
    }

    private fun clearSearchResults() {
        channelAdapter.submitList(emptyList())
        binding.tvNoResults.visibility = View.VISIBLE
        binding.rvSearchResults.visibility = View.GONE
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.searchResults.collect { channels ->
                if (channels.isNotEmpty()) {
                    channelAdapter.submitList(channels)
                    binding.tvNoResults.visibility = View.GONE
                    binding.rvSearchResults.visibility = View.VISIBLE
                } else {
                    if (binding.etSearch.text.toString().isNotBlank()) {
                        binding.tvNoResults.visibility = View.VISIBLE
                    } else {
                        binding.tvNoResults.visibility = View.GONE
                    }
                    channelAdapter.submitList(emptyList())
                }
            }
        }

        lifecycleScope.launch {
            viewModel.isLoading.collect { isLoading ->
                binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            }
        }

        lifecycleScope.launch {
            viewModel.error.collect { error ->
                error?.let {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun navigateToChannelDetail(channel: com.demo.streamflix.data.model.Channel) {
        val action = NavGraphDirections.actionGlobalChannelDetailFragment(channel)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        searchJob?.cancel()
        _binding = null
    }
}