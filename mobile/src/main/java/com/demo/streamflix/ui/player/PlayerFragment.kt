package com.demo.streamflix.ui.player

import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.demo.streamflix.R
import com.demo.streamflix.data.model.Channel
import com.demo.streamflix.databinding.FragmentPlayerBinding
import com.demo.streamflix.util.Extensions.showToast
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.gms.cast.MediaInfo
import com.google.android.gms.cast.MediaMetadata
import com.google.android.gms.cast.framework.CastContext
import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.cast.framework.SessionManagerListener
import com.google.android.gms.common.images.WebImage
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

    private var exoPlayer: ExoPlayer? = null
    private var isFullscreen = false

    private lateinit var castContext: CastContext
    private var castSession: CastSession? = null
    private lateinit var sessionManagerListener: SessionManagerListener<CastSession>

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
        setupCast()
    }

    private fun setupUI() {
        binding.tvChannelName.text = args.channel.name
        binding.ivBack.setOnClickListener { findNavController().navigateUp() }
        binding.btnFullscreen.setOnClickListener { toggleFullscreen() }
        binding.btnFavorite.setOnClickListener { viewModel.toggleFavorite(args.channel) }
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.isFavorite.collect { isFavorite ->
                updateFavoriteButton(isFavorite)
            }
        }
    }

    private fun initializePlayer() {
        exoPlayer = exoPlayerManager.createPlayer(requireContext()).apply {
            addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(playbackState: Int) {
                    binding.progressBar.visibility = if (playbackState == Player.STATE_BUFFERING) View.VISIBLE else View.GONE
                }

                override fun onPlayerError(error: PlaybackException) {
                    showToast("Error: ${error.message}")
                }
            })
        }
        binding.playerView.player = exoPlayer
        loadStream(args.channel)
    }

    private fun loadStream(channel: Channel) {
        val mediaItem = MediaItem.fromUri(channel.streamUrl)
        val mediaSource = HlsMediaSource.Factory(DefaultHttpDataSource.Factory()).createMediaSource(mediaItem)
        exoPlayer?.setMediaSource(mediaSource)
        exoPlayer?.prepare()
        exoPlayer?.play()
        viewModel.checkIfFavorite(channel.id)
    }

    private fun setupCast() {
        castContext = CastContext.getSharedInstance(requireContext())
        CastContext.getSharedInstance(requireContext()).setReceiverApplicationId(com.google.android.gms.cast.CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID)
        sessionManagerListener = object : SessionManagerListener<CastSession> {
            override fun onSessionStarted(session: CastSession, sessionId: String) {
                castSession = session
                exoPlayer?.pause()
                loadRemoteMedia(args.channel)
            }

            override fun onSessionResumed(session: CastSession, wasSuspended: Boolean) {
                castSession = session
            }

            override fun onSessionEnding(session: CastSession) {
                castSession = null
            }

            override fun onSessionEnded(session: CastSession, error: Int) {
                castSession = null
                exoPlayer?.play()
            }
            override fun onSessionStarting(p0: CastSession) {}
            override fun onSessionStartFailed(p0: CastSession, p1: Int) {}
            override fun onSessionResuming(p0: CastSession, p1: String) {}
            override fun onSessionResumeFailed(p0: CastSession, p1: Int) {}
            override fun onSessionSuspended(p0: CastSession, p1: Int) {}
        }
        castContext.sessionManager.addSessionManagerListener(sessionManagerListener, CastSession::class.java)
        com.google.android.gms.cast.framework.CastButtonFactory.setUpMediaRouteButton(requireContext(), binding.mediaRouteButton)
    }

    private fun loadRemoteMedia(channel: Channel) {
        val mediaMetadata = MediaMetadata(MediaMetadata.MEDIA_TYPE_MOVIE).apply {
            putString(MediaMetadata.KEY_TITLE, channel.name)
            putString(MediaMetadata.KEY_SUBTITLE, channel.description)
            addImage(WebImage(Uri.parse(channel.logo)))
        }
        val mediaInfo = MediaInfo.Builder(channel.streamUrl)
            .setStreamType(MediaInfo.STREAM_TYPE_LIVE)
            .setContentType("application/x-mpegURL")
            .setMetadata(mediaMetadata)
            .build()
        castSession?.remoteMediaClient?.load(mediaInfo, true)
    }

    private fun toggleFullscreen() {
        isFullscreen = !isFullscreen
        if (isFullscreen) {
            requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        } else {
            requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
    }

    private fun updateFavoriteButton(isFavorite: Boolean) {
        binding.btnFavorite.setImageResource(if (isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border)
    }

    private fun releasePlayer() {
        exoPlayer?.release()
        exoPlayer = null
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }

    override fun onResume() {
        super.onResume()
        castContext.sessionManager.addSessionManagerListener(sessionManagerListener, CastSession::class.java)
        if (castSession == null) exoPlayer?.play()
    }

    override fun onPause() {
        super.onPause()
        castContext.sessionManager.removeSessionManagerListener(sessionManagerListener, CastSession::class.java)
        exoPlayer?.pause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        releasePlayer()
        _binding = null
    }
}