package com.demo.streamflix.data.mapper

import com.demo.streamflix.data.local.entity.CategoryEntity
import com.demo.streamflix.data.model.Category

fun Category.toEntity(): CategoryEntity {
    return CategoryEntity(
        id = id,
        name = name,
        description = description,
        iconUrl = iconUrl,
        isActive = true, // Assuming default value
        createdAt = "", // Assuming default value
        updatedAt = "" // Assuming default value
    )
}

fun List<Category>.toEntities(): List<CategoryEntity> {
    return map { it.toEntity() }
}
