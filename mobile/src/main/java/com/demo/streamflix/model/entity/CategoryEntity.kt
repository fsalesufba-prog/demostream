package com.demo.streamflix.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryEntity(
    val id: Long,
    val name: String,
    val description: String,
    @SerialName("icon_url")
    val iconUrl: String,
    @SerialName("is_active")
    val isActive: Boolean,
    @SerialName("created_at")
    val createdAt: String, // Using String for LocalDateTime
    @SerialName("updated_at")
    val updatedAt: String // Using String for LocalDateTime
)