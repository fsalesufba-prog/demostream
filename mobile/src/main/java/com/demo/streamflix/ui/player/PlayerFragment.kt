package com.demo.streamflix.ui.player

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.demo.streamflix.R
import com.demo.streamflix.databinding.FragmentPlayerBinding
import com.demo.streamflix.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PlayerFragment : Fragment() {

    private var _binding: FragmentPlayerBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PlayerViewModel by viewModels()
    private val args: PlayerFragmentArgs by navArgs()

    @Inject
    lateinit var exoPlayerManager: ExoPlayerManager

    private var isFullscreen = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
        initializePlayer()
    }

    private fun setupUI() {
        // Corrigido: args.channel.name (não args.channel.id)
        binding.tvChannelName.text = args.channel.name

        // Formatar número do canal com 3 dígitos
        val channelNumber = args.channel.number
        binding.tvChannelNumber.text = String.format("%03d", channelNumber)

        binding.ivBack.setOnClickListener { findNavController().navigateUp() }
        binding.btnFullscreen.setOnClickListener { toggleFullscreen() }
        binding.btnFavorite.setOnClickListener {
            // Corrigido: Passar o ID (Long) em vez do nome (String)
            viewModel.toggleFavorite(args.channel.id)
        }
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isFavorite.collect { isFavorite ->
                updateFavoriteButton(isFavorite)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isLoading.collect { isLoading ->
                if (isLoading) {
                    binding.tvLoading.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.VISIBLE
                } else {
                    binding.tvLoading.visibility = View.GONE
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }

    private fun initializePlayer() {
        val player = exoPlayerManager.createPlayer()
        binding.playerView.player = player

        player.addListener(object : androidx.media3.common.Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                when (playbackState) {
                    androidx.media3.common.Player.STATE_BUFFERING -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.tvLoading.visibility = View.VISIBLE
                    }
                    androidx.media3.common.Player.STATE_READY -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvLoading.visibility = View.GONE
                    }
                    androidx.media3.common.Player.STATE_ENDED -> {
                        showToast("Stream ended")
                    }
                }
            }

            override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
                showToast("Error: ${error.message}")
                // Corrigido: usar R.string.stream_error
                binding.tvLoading.text = requireContext().getString(R.string.stream_error)
                binding.tvLoading.visibility = View.VISIBLE
            }
        })

        // Carregar o stream
        loadStream(args.channel)
    }

    private fun loadStream(channel: com.demo.streamflix.data.model.Channel) {
        try {
            viewModel.setLoading(true)

            // Corrigido: usar streamUrl em vez de url
            val streamUrl = channel.streamUrl ?: channel.url
            if (streamUrl.isNullOrEmpty()) {
                throw IllegalArgumentException("Stream URL is empty")
            }

            exoPlayerManager.play(streamUrl)
            viewModel.checkIfFavorite(channel.id)

        } catch (e: Exception) {
            showToast("Error loading stream: ${e.message}")
            // Corrigido: usar R.string.stream_error
            binding.tvLoading.text = requireContext().getString(R.string.stream_error)
            binding.tvLoading.visibility = View.VISIBLE
        } finally {
            viewModel.setLoading(false)
        }
    }

    private fun toggleFullscreen() {
        isFullscreen = !isFullscreen
        if (isFullscreen) {
            requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            binding.controlsOverlay.visibility = View.GONE
        } else {
            requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            binding.controlsOverlay.visibility = View.VISIBLE
        }
    }

    private fun updateFavoriteButton(isFavorite: Boolean) {
        val iconRes = if (isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border
        binding.btnFavorite.setImageResource(iconRes)
    }

    override fun onPause() {
        super.onPause()
        exoPlayerManager.getPlayer()?.pause()
    }

    override fun onResume() {
        super.onResume()
        exoPlayerManager.getPlayer()?.play()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        exoPlayerManager.releasePlayer()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        _binding = null
    }
}