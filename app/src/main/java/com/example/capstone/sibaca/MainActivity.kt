package com.example.capstone.sibaca

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        navController = findNavController(R.id.navHostFragment)

        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setOnItemSelectedListener { item ->
            val destination = when (item.itemId) {
                R.id.recentlyFragment -> R.id.recentlyFragment
                R.id.profileFragment -> R.id.profileFragment
                R.id.cameraFragment -> R.id.cameraFragment
                else -> throw IllegalArgumentException("Unknown destination")
            }
            navController.navigate(destination)
            true
        }
    }
}
