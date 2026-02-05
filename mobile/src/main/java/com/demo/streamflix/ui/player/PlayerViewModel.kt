package com.demo.streamflix.ui.player

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.streamflix.data.repository.ChannelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val channelRepository: ChannelRepository
) : ViewModel() {

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }

    // CORRIGIDO: Aceita Long
    fun checkIfFavorite(channelId: Long) {
        viewModelScope.launch {
            try {
                _isFavorite.value = channelRepository.isChannelFavorite(channelId)
            } catch (e: Exception) {
                _isFavorite.value = false
            }
        }
    }

    // CORRIGIDO: Aceita Long
    fun toggleFavorite(channelId: Long) {
        viewModelScope.launch {
            try {
                val current = _isFavorite.value
                val newValue = !current

                channelRepository.toggleFavorite(channelId)
                _isFavorite.value = newValue
            } catch (e: Exception) {
                // Tratar erro
            }
        }
    }
}