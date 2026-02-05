package com.demo.streamflix.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: String,
    val email: String,
    val name: String,
    val password: String,
    val phone: String? = null,
    @ColumnInfo("avatar_url")
    val avatarUrl: String? = null,
    @ColumnInfo("membership_expiry")
    val membershipExpiry: String? = null,
    @ColumnInfo("is_active")
    val isActive: Boolean = true,
    @ColumnInfo("is_admin")
    val isAdmin: Boolean = false,
    @ColumnInfo("created_at")
    val createdAt: String,
    @ColumnInfo("updated_at")
    val updatedAt: String,
    @ColumnInfo("last_login")
    val lastLogin: String? = null
)
