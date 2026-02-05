package com.demo.streamflix.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.streamflix.model.dao.CategoryDao
import com.demo.streamflix.data.local.entity.CategoryEntity

@Database(
    entities = [CategoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
}
