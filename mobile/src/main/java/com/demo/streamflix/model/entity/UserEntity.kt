package com.demo.streamflix.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.util.UUID

@Serializable
data class UserEntity(
    val id: String, // UUID is sent as a string
    val email: String,
    val name: String,
    val password: String, // Note: Be careful with password handling
    val phone: String? = null,
    @SerialName("avatar_url")
    val avatarUrl: String? = null,
    @SerialName("membership_expiry")
    val membershipExpiry: String? = null, // Using String for LocalDateTime
    @SerialName("is_active")
    val isActive: Boolean = true,
    @SerialName("is_admin")
    val isAdmin: Boolean = false,
    @SerialName("created_at")
    val createdAt: String, // Using String for LocalDateTime
    @SerialName("updated_at")
    val updatedAt: String, // Using String for LocalDateTime
    @SerialName("last_login")
    val lastLogin: String? = null // Using String for LocalDateTime
)