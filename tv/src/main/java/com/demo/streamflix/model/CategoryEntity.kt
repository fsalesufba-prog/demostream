package com.demo.streamflix.model.entity

import androidx.room.*
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String? = null,

    @ColumnInfo(name = "icon_url")
    val iconUrl: String? = null,

    @ColumnInfo(name = "is_active")
    val isActive: Boolean = true,

    @ColumnInfo(name = "created_at")
    val createdAt: Date = Date(), // Usando Date ao invés de LocalDateTime

    @ColumnInfo(name = "updated_at")
    val updatedAt: Date = Date()
) {
    // Índices para melhor performance
    @Ignore
    companion object {
        const val INDEX_NAME = "idx_categories_name"
    }
}