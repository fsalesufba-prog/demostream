package com.demo.streamflix.data.local.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.demo.streamflix.data.local.converter.DateConverter;
import com.demo.streamflix.model.entity.CategoryEntity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/demo/streamflix/data/local/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "mobile_debug"})
@androidx.room.Database(entities = {com.demo.streamflix.model.entity.CategoryEntity.class}, version = 1)
@androidx.room.TypeConverters(value = {com.demo.streamflix.data.local.converter.DateConverter.class})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
}