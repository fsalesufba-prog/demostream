package com.demo.streamflix.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.streamflix.data.local.entity.CategoryEntity
import com.demo.streamflix.data.local.entity.ChannelEntity
import com.demo.streamflix.data.repository.CategoryRepository
import com.demo.streamflix.data.repository.ChannelRepository
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

    private val _nacionalChannels = MutableStateFlow<List<ChannelEntity>>(emptyList())
    val nacionalChannels: StateFlow<List<ChannelEntity>> = _nacionalChannels.asStateFlow()

    private val _actualidadChannels = MutableStateFlow<List<ChannelEntity>>(emptyList())
    val actualidadChannels: StateFlow<List<ChannelEntity>> = _actualidadChannels.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadAllData()
    }

    private fun loadAllData() {
        loadCategories()
        loadNacionalChannels()
        loadActualidadChannels()
    }

    fun loadCategories() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                val result = categoryRepository.getAllCategories()
                _categories.value = result
            } catch (e: Exception) {
                _error.value = "Error al cargar categorías: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadNacionalChannels() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val channels = channelRepository.getChannelsForCategory(1L) // ID para Nacional
                _nacionalChannels.value = channels.filter { it.isActive }
            } catch (e: Exception) {
                _error.value = "Error al cargar canales nacionales: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadActualidadChannels() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val channels = channelRepository.getChannelsForCategory(2L) // ID para Actualidad
                _actualidadChannels.value = channels.filter { it.isActive }
            } catch (e: Exception) {
                _error.value = "Error al cargar canales de actualidad: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun refreshAll() {
        loadAllData()
    }
}