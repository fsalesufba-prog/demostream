package com.demo.streamflix.ui.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.leanback.app.SearchSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.ObjectAdapter
import androidx.lifecycle.ViewModelProvider
import com.demo.streamflix.data.repository.ChannelRepository
import com.demo.streamflix.ui.presenter.ChannelCardPresenter
import com.demo.streamflix.util.SearchResultProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : SearchSupportFragment(), SearchSupportFragment.SearchResultProvider {

    @Inject
    lateinit var channelRepository: ChannelRepository

    private lateinit var rowsAdapter: ArrayObjectAdapter
    private lateinit var searchResultProvider: SearchResultProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        setSearchResultProvider(this)
        searchResultProvider = SearchResultProvider(channelRepository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSpeechRecognitionCallback {
            val intent = Intent(android.speech.RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(android.speech.RecognizerIntent.EXTRA_LANGUAGE_MODEL, android.speech.RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            startActivityForResult(intent, SPEECH_RECOGNITION_REQUEST_CODE)
        }
    }

    override fun getResultsAdapter(): ObjectAdapter {
        return rowsAdapter
    }

    override fun onQueryTextChange(newQuery: String): Boolean {
        searchResultProvider.search(newQuery, object : SearchResultProvider.SearchResultListener {
            override fun onSearchResult(results: List<Any>) {
                val cardPresenter = ChannelCardPresenter()
                val listRowAdapter = ArrayObjectAdapter(cardPresenter)
                listRowAdapter.addAll(0, results)
                val header = androidx.leanback.widget.HeaderItem("Resultados da busca")
                val listRow = ListRow(header, listRowAdapter)
                rowsAdapter.clear()
                rowsAdapter.add(listRow)
            }
        })
        return true
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        return true
    }

    companion object {
        private const val SPEECH_RECOGNITION_REQUEST_CODE = 1
    }
}