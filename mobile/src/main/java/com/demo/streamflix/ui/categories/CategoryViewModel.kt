package com.demo.streamflix.ui.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.streamflix.data.repository.ChannelRepository
import com.demo.streamflix.data.local.entity.ChannelEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val channelRepository: ChannelRepository
) : ViewModel() {

    private val _channels = MutableStateFlow<List<ChannelEntity>>(emptyList())
    val channels: StateFlow<List<ChannelEntity>> = _channels.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun loadChannelsByCategory(categoryId: Long) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                _channels.value = channelRepository.getChannelsForCategory(categoryId)
            } catch (e: Exception) {
                _error.value = e.message ?: "Failed to load channels"
            } finally {
                _isLoading.value = false
            }
        }
    }
}