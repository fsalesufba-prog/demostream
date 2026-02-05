package com.demo.streamflix

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.demo.streamflix.util.SharedPrefs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            delay(1000)
            validateMembership()
        }
    }

    private fun validateMembership() {
        val isLoggedIn = sharedPrefs.getBoolean("is_logged_in", false)

        if (isLoggedIn) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("destination", R.id.loginFragment)
            startActivity(intent)
        }
        finish()
    }
}