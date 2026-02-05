package com.demo.streamflix.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.lifecycle.lifecycleScope
import com.demo.streamflix.model.Category
import com.demo.streamflix.model.Channel
import com.demo.streamflix.ui.presenter.ChannelCardPresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BrowseSupportFragment() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObservers()
        loadData()
    }

    private fun setupUI() {
        title = "Streamflix"
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true
        brandColor = resources.getColor(R.color.primary)
        searchAffordanceColor = resources.getColor(R.color.accent)
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.categories.collect { categories ->
                loadRows(categories, viewModel.channels.value)
            }
        }

        lifecycleScope.launch {
            viewModel.channels.collect { channels ->
                loadRows(viewModel.categories.value, channels)
            }
        }
    }

    private fun loadData() {
        viewModel.loadCategories()
        viewModel.loadChannels()
    }

    private fun loadRows(categories: List<Category>, channels: List<Channel>) {
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        val cardPresenter = ChannelCardPresenter()

        for (category in categories) {
            val listRowAdapter = ArrayObjectAdapter(cardPresenter)
            val categoryChannels = channels.filter { it.categoryId == category.id }
            listRowAdapter.addAll(0, categoryChannels)
            val header = HeaderItem(category.id.toLong(), category.name)
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }

        adapter = rowsAdapter
    }
}