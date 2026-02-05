package com.demo.streamflix.data.repository

import com.demo.streamflix.data.local.entity.ChannelEntity
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChannelRepository @Inject constructor() {
    
    suspend fun getChannelsForCategory(categoryId: Long): List<ChannelEntity> {
        delay(1000)
        
        return when (categoryId) {
            1L -> listOf(
                ChannelEntity(
                    id = 101,
                    number = 1,
                    name = "ESPN",
                    description = "Canal de esportes",
                    logoUrl = "https://example.com/espn.png",
                    streamUrl = "https://example.com/stream101.m3u8",
                    categoryId = categoryId,
                    isHd = true,
                    isActive = true,
                    createdAt = "2024-01-01",
                    updatedAt = "2024-01-01"
                ),
                ChannelEntity(
                    id = 102,
                    number = 2,
                    name = "Fox Sports",
                    description = "Esportes variados",
                    logoUrl = "https://example.com/foxsports.png",
                    streamUrl = "https://example.com/stream102.m3u8",
                    categoryId = categoryId,
                    isHd = true,
                    isActive = true,
                    createdAt = "2024-01-01",
                    updatedAt = "2024-01-01"
                )
            )
            2L -> listOf(
                ChannelEntity(
                    id = 201,
                    number = 10,
                    name = "HBO",
                    description = "Filmes e séries",
                    logoUrl = "https://example.com/hbo.png",
                    streamUrl = "https://example.com/stream201.m3u8",
                    categoryId = categoryId,
                    isHd = true,
                    isActive = true,
                    createdAt = "2024-01-01",
                    updatedAt = "2024-01-01"
                ),
                ChannelEntity(
                    id = 202,
                    number = 11,
                    name = "Cinecanal",
                    description = "Filmes 24/7",
                    logoUrl = "https://example.com/cinecanal.png",
                    streamUrl = "https://example.com/stream202.m3u8",
                    categoryId = categoryId,
                    isHd = false,
                    isActive = true,
                    createdAt = "2024-01-01",
                    updatedAt = "2024-01-01"
                )
            )
            else -> emptyList()
        }
    }
    suspend fun isChannelFavorite(channelId: Long): Boolean {
        delay(300) // Simular delay
        return channelId % 2 == 0L // Exemplo: canais pares são favoritos
    }
    
    suspend fun toggleFavorite(channelId: Long): Boolean {
        delay(300) // Simular delay
        return !isChannelFavorite(channelId) // Alterna o estado
    }
}