package com.demo.streamflix.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.streamflix.data.repository.CategoryRepository
import com.demo.streamflix.data.repository.ChannelRepository
import com.demo.streamflix.data.local.entity.CategoryEntity
import com.demo.streamflix.data.local.entity.ChannelEntity
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

    private val _categories = MutableStateFlow<List<CategoryEntity>>(emptyList())
    val categories: StateFlow<List<CategoryEntity>> = _categories.asStateFlow()

    private val _featuredChannels = MutableStateFlow<List<ChannelEntity>>(emptyList())
    val featuredChannels: StateFlow<List<ChannelEntity>> = _featuredChannels.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun loadCategories() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val categories = categoryRepository.getAllCategories()
                _categories.value = categories
            } catch (e: Exception) {
                _error.value = e.message ?: "Failed to load categories"
            } finally {
                _isLoading.value = false
            }
        }
    }

    /*
    fun loadFeaturedChannels(refresh: Boolean = false) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                // TODO: Implement logic to get featured channels from Supabase
                // val channels = channelRepository.getFeaturedChannels(refresh)
                // _featuredChannels.value = channels
            } catch (e: Exception) {
                _error.value = e.message ?: "Failed to load channels"
            } finally {
                _isLoading.value = false
            }
        }
    }
    */
}