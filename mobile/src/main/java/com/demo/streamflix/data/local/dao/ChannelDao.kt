package com.demo.streamflix.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.streamflix.data.local.entity.ChannelEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChannelDao {

    @Query("SELECT * FROM channels ORDER BY number ASC")
    fun getAll(): Flow<List<ChannelEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(channels: List<ChannelEntity>)

    @Query("DELETE FROM channels")
    suspend fun clear()
}
