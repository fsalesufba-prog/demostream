package com.demo.streamflix.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.demo.streamflix.databinding.FragmentCategoryBinding
import com.demo.streamflix.ui.adapters.ChannelAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
abstract class CategoryBaseFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CategoryViewModel by viewModels()
    private lateinit var channelAdapter: ChannelAdapter

    abstract fun getCategoryId(): Int
    abstract fun getCategoryName(): String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        observeViewModel()
        loadChannels()
    }

    private fun setupUI() {
        binding.toolbar.title = getCategoryName()
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        channelAdapter = ChannelAdapter { channel ->
            navigateToChannelDetail(channel)
        }
        
        binding.rvChannels.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = channelAdapter
        }
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
        
        findNavController().navigate(
            com.demo.streamflix.R.id.action_global_channelDetailFragment,
            bundle
        )
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.channels.collect { channels ->
                channelAdapter.submitList(channels)
                
                if (channels.isEmpty()) {
                    binding.tvNoChannels.visibility = View.VISIBLE
                    binding.rvChannels.visibility = View.GONE
                } else {
                    binding.tvNoChannels.visibility = View.GONE
                    binding.rvChannels.visibility = View.VISIBLE
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isLoading.collect { isLoading ->
                binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.error.collect { error ->
                error?.let {
                    // Mostrar erro se necessário
                }
            }
        }
    }

    protected fun loadChannels() {
        viewModel.loadChannelsByCategory(getCategoryId().toLong())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}