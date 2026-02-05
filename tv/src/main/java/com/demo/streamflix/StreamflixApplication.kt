package com.demo.streamflix

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StreamflixApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        // Inicialize aqui suas bibliotecas/configurações
    }
}