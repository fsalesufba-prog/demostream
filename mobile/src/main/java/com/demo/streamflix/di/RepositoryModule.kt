package com.demo.streamflix.di

import com.demo.streamflix.data.repository.AuthRepository
import com.demo.streamflix.data.repository.CategoryRepository
import com.demo.streamflix.data.repository.ChannelRepository
import com.demo.streamflix.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(): AuthRepository {
        val supabaseClient = SupabaseClientFactory.create()
        return AuthRepository(supabaseClient)
    }

    @Provides
    fun provideCategoryRepository(): CategoryRepository {
        val supabaseClient = SupabaseClientFactory.create()
        return CategoryRepository(supabaseClient)
    }

    @Provides
    fun provideChannelRepository(): ChannelRepository {
        val supabaseClient = SupabaseClientFactory.create()
        return ChannelRepository(supabaseClient)
    }

    @Provides
    fun provideUserRepository(): UserRepository {
        val supabaseClient = SupabaseClientFactory.create()
        return UserRepository(supabaseClient)
    }
}