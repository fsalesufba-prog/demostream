package com.demo.streamflix.data.mapper

import com.demo.streamflix.data.local.entity.CategoryEntity
import com.demo.streamflix.data.model.Category
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun List<Category>.toEntities(): List<CategoryEntity> {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
    val now = sdf.format(Date())
    return this.map { category ->
        CategoryEntity(
            id = category.id.toLong(),
            name = category.name,
            description = category.description,
            iconUrl = category.iconUrl,
            isActive = true,
            createdAt = now,
            updatedAt = now
        )
    }
}
