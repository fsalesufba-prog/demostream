package com.demo.streamflix.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.demo.streamflix.data.local.converter.DateConverter
import com.demo.streamflix.data.local.dao.CategoryDao
import com.demo.streamflix.data.local.dao.ChannelDao
import com.demo.streamflix.data.local.dao.UserDao
import com.demo.streamflix.data.local.entity.CategoryEntity
import com.demo.streamflix.data.local.entity.ChannelEntity
import com.demo.streamflix.data.local.entity.UserEntity

@Database(entities = [CategoryEntity::class, ChannelEntity::class, UserEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun channelDao(): ChannelDao
    abstract fun userDao(): UserDao
}