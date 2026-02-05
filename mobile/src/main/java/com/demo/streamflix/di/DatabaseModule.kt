package com.demo.streamflix.di

import android.content.Context
import androidx.room.Room
import com.demo.streamflix.model.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "streamflix.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideCategoryDao(db: AppDatabase) = db.categoryDao()
}
