package com.demo.streamflix.util

import android.os.Handler
import android.os.Looper
import com.demo.streamflix.data.repository.ChannelRepository

class SearchResultProvider(private val channelRepository: ChannelRepository) {

    private val handler = Handler(Looper.getMainLooper())
    private var pendingQuery: String? = null

    interface SearchResultListener {
        fun onSearchResult(results: List<Any>)
    }

    fun search(query: String, listener: SearchResultListener) {
        pendingQuery = query
        handler.removeCallbacksAndMessages(null)
        handler.postDelayed({
            if (query == pendingQuery) {
                // Simulate network latency
                Thread.sleep(500)
                val results = channelRepository.searchChannels(query)
                listener.onSearchResult(results)
            }
        }, 500)
    }
}