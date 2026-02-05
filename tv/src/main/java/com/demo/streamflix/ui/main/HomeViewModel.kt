package com.demo.streamflix.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.streamflix.data.repository.CategoryRepository
import com.demo.streamflix.data.repository.ChannelRepository
import com.demo.streamflix.model.Category
import com.demo.streamflix.model.Channel
import com.demo.streamflix.model.mapper.toCategory
import com.demo.streamflix.model.mapper.toChannel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val channelRepository: ChannelRepository
) : ViewModel() {

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories.asStateFlow()

    private val _channels = MutableStateFlow<List<Channel>>(emptyList())
    val channels: StateFlow<List<Channel>> = _channels.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun loadCategories() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val categoryEntities = categoryRepository.getAllCategories()
                _categories.value = categoryEntities.map { it.toCategory() }
            } catch (e: Exception) {
                _error.value = e.message ?: "Failed to load categories"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadChannels() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val channelEntities = channelRepository.getAllChannels()
                _channels.value = channelEntities.map { it.toChannel() }
            } catch (e: Exception) {
                _error.value = e.message ?: "Failed to load channels"
            } finally {
                _isLoading.value = false
            }
        }
    }
}