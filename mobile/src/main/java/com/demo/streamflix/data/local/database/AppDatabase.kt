package com.demo.streamflix.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.demo.streamflix.data.local.converter.DateConverter
import com.demo.streamflix.data.local.entity.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    // Add your DAOs here
}