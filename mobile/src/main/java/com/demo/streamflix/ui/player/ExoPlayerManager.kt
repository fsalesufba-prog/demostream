package com.demo.streamflix.ui.player

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.hls.HlsMediaSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExoPlayerManager @Inject constructor(
    private val context: Context
) {

    private var exoPlayer: ExoPlayer? = null

    fun createPlayer(): ExoPlayer {
        releasePlayer()

        exoPlayer = ExoPlayer.Builder(context)
            .build()

        return exoPlayer!!
    }

    fun play(url: String) {
        exoPlayer?.let { player ->
            val dataSourceFactory = DefaultHttpDataSource.Factory()
            val mediaSource = HlsMediaSource.Factory(dataSourceFactory)
                .createMediaSource(MediaItem.fromUri(url))

            player.setMediaSource(mediaSource)
            player.prepare()
            player.play()
        }
    }

    fun releasePlayer() {
        exoPlayer?.release()
        exoPlayer = null
    }

    fun getPlayer(): ExoPlayer? = exoPlayer
}