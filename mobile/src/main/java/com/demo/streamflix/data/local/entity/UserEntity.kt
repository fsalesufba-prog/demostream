package com.demo.streamflix.data.local.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserEntity(
    val id: String,
    val email: String,
    val name: String,
    val password: String,
    val phone: String? = null,
    @SerialName("avatar_url")
    val avatarUrl: String? = null,
    @SerialName("membership_expiry")
    val membershipExpiry: String? = null,
    @SerialName("is_active")
    val isActive: Boolean = true,
    @SerialName("is_admin")
    val isAdmin: Boolean = false,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("last_login")
    val lastLogin: String? = null
)
