package com.demo.streamflix.util

import android.content.Context
import android.content.SharedPreferences

class SharedPrefs(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("StreamflixPrefs", Context.MODE_PRIVATE)

    fun getString(key: String, defaultValue: String?): String? {
        return prefs.getString(key, defaultValue)
    }

    fun putString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return prefs.getBoolean(key, defaultValue)
    }

    fun putBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }
}