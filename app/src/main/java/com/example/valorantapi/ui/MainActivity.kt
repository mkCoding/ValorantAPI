package com.example.valorantapi.ui

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.valorantapi.R
import com.example.valorantapi.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.google.firebase.analytics.logEvent
import dagger.hilt.android.AndroidEntryPoint
import java.lang.RuntimeException

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    //Adding Firebase Analytics object
//    private lateinit var firebaseAnalytics: FirebaseAnalytics

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

//        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT) {
//            param(FirebaseAnalytics.Param.ITEM_ID, "232");
//            param(FirebaseAnalytics.Param.ITEM_NAME, "number");
//            param(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
//        }


//        val crashButton = Button(this)
//        crashButton.text = "Test Crash"
//        crashButton.setOnClickListener {
//            throw RuntimeException("Test Crash") // Force a crash
//        }
//
//        addContentView(crashButton, ViewGroup.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT))



//
//        //checks when a user clicks on a specific element in your app
//        Firebase.analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
//            bundleOf(
//                Pair(FirebaseAnalytics.Param.ITEM_ID , "ivBackButton"),
//                Pair(FirebaseAnalytics.Param.ITEM_NAME, "backbutton"),
//                Pair(FirebaseAnalytics.Param.CONTENT_TYPE, "ImageView")
//            )
//        }



    }
}