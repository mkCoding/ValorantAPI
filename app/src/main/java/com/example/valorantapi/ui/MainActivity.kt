package com.example.valorantapi.ui

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.valorantapi.R
import com.example.valorantapi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)


        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.agents -> navController.navigate(R.id.agentsFragment)
                R.id.weapons -> navController.navigate(R.id.weaponsFragment)
                else -> {}

            }
            true
        }

       navController.addOnDestinationChangedListener { _, destination, _ ->
           if (destination.id == R.id.agentDetailsFragment) {
               binding.bottomNavigationView.visibility = View.GONE
           } else {
               binding.bottomNavigationView.visibility = View.VISIBLE
           }
       }


    }
}