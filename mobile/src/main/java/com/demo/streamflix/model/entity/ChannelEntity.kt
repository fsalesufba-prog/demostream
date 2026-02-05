package com.demo.streamflix.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChannelEntity(
    val id: Long,
    val number: Int,
    val name: String,
    val description: String,
    @SerialName("logo_url")
    val logoUrl: String,
    @SerialName("stream_url")
    val streamUrl: String,
    @SerialName("category_id")
    val categoryId: Long,
    @SerialName("is_hd")
    val isHd: Boolean = false,
    @SerialName("is_active")
    val isActive: Boolean = true,
    @SerialName("created_at")
    val createdAt: String, // Using String for LocalDateTime
    @SerialName("updated_at")
    val updatedAt: String // Using String for LocalDateTime
)
