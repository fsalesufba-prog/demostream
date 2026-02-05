package com.demo.streamflix.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channels")
data class ChannelEntity(
    @PrimaryKey
    val id: Long,
    val number: Int,
    val name: String,
    val description: String,
    @ColumnInfo("logo_url")
    val logoUrl: String,
    @ColumnInfo("stream_url")
    val streamUrl: String,
    @ColumnInfo("category_id")
    val categoryId: Long,
    @ColumnInfo("is_hd")
    val isHd: Boolean = false,
    @ColumnInfo("is_active")
    val isActive: Boolean = true,
    @ColumnInfo("created_at")
    val createdAt: String,
    @ColumnInfo("updated_at")
    val updatedAt: String
)
