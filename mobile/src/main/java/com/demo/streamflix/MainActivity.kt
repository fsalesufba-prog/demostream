package com.demo.streamflix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.demo.streamflix.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
        setupBottomNavigation()

        val destination = intent.getIntExtra("destination", -1)
        if (destination != -1) {
            navController.navigate(destination)
        }
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setupWithNavController(navController)

        // Hide bottom navigation on certain destinations
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment,
                R.id.splashFragment,
                R.id.playerFragment -> {
                    binding.bottomNavigation.visibility = android.view.View.GONE
                }
                else -> {
                    binding.bottomNavigation.visibility = android.view.View.VISIBLE
                }
            }
        }
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id == R.id.homeFragment) {
            showExitConfirmation()
        } else {
            super.onBackPressed()
        }
    }

    private fun showExitConfirmation() {
        MaterialAlertDialogBuilder(this)
            .setTitle(getString(R.string.exit_app))
            .setMessage(getString(R.string.exit_confirmation_message))
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                finishAffinity()
            }
            .setNegativeButton(getString(R.string.no), null)
            .show()
    }
}