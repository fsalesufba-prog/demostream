package com.demo.streamflix.di;

import com.demo.streamflix.data.repository.AuthRepository;
import com.demo.streamflix.data.repository.CategoryRepository;
import com.demo.streamflix.data.repository.ChannelRepository;
import com.demo.streamflix.data.repository.UserRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/streamflix/di/RepositoryModule;", "", "()V", "provideAuthRepository", "Lcom/demo/streamflix/data/repository/AuthRepository;", "provideCategoryRepository", "Lcom/demo/streamflix/data/repository/CategoryRepository;", "provideChannelRepository", "Lcom/demo/streamflix/data/repository/ChannelRepository;", "provideUserRepository", "Lcom/demo/streamflix/data/repository/UserRepository;", "mobile_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class RepositoryModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.demo.streamflix.di.RepositoryModule INSTANCE = null;
    
    private RepositoryModule() {
        super();
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.demo.streamflix.data.repository.AuthRepository provideAuthRepository() {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.demo.streamflix.data.repository.CategoryRepository provideCategoryRepository() {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.demo.streamflix.data.repository.ChannelRepository provideChannelRepository() {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.demo.streamflix.data.repository.UserRepository provideUserRepository() {
        return null;
    }
}