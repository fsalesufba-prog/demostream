package com.demo.streamflix.data.repository

import com.demo.streamflix.data.local.entity.CategoryEntity
import com.demo.streamflix.data.mapper.toEntities
import com.demo.streamflix.data.model.Category
import io.github.jan.supabase.SupabaseClient
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryRepository @Inject constructor(
    private val supabaseClient: SupabaseClient
) {

    suspend fun getAllCategories(): List<CategoryEntity> {
        delay(800)

        return listOf(
            Category(
                id = 1,
                name = "Nacional",
                description = "Canais nacionais",
                iconUrl = "https://example.com/nacional.png",
                channelCount = 15
            ),
            Category(
                id = 2,
                name = "Actualidad",
                description = "Notícias e atualidades",
                iconUrl = "https://example.com/actualidad.png",
                channelCount = 10
            ),
            Category(
                id = 3,
                name = "Deportes",
                description = "Canais esportivos",
                iconUrl = "https://example.com/deportes.png",
                channelCount = 8
            ),
            Category(
                id = 4,
                name = "Películas",
                description = "Filmes e séries",
                iconUrl = "https://example.com/peliculas.png",
                channelCount = 12
            ),
            Category(
                id = 5,
                name = "Infantil",
                description = "Canais infantis",
                iconUrl = "https://example.com/infantil.png",
                channelCount = 6
            )
        ).toEntities()
    }
}