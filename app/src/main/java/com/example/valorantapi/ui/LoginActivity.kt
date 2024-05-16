package com.example.valorantapi.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.valorantapi.R
import com.example.valorantapi.databinding.ActivityLoginBinding
import com.example.valorantapi.ui.agent.AgentsFragment
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.google.firebase.analytics.logEvent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private lateinit var auth: FirebaseAuth


    private fun isVerifiedUser(){
        auth.signInWithEmailAndPassword(binding.etEmailAddress.text.toString(), binding.editTextTextPassword.text.toString()).addOnCompleteListener {task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d("LoginActivity", "loginUserWithEmail:success")
                val user = auth.currentUser
                goToMainActivity()
            } else {
                // If sign in fails, display a message to the user.
                Log.w("LoginActivity", "createUserWithEmail:failure", task.exception)
                Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT,).show()
            }

        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the FirebaseAnalytics instance.
        //firebaseAnalytics = Firebase.analytics
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.btnLogin.setOnClickListener {
            isVerifiedUser()
        }

        binding.apply {

//            testCrash.setOnClickListener {

//                //Test Analytics in Firebase
//                Firebase.analytics.logEvent(
//                    FirebaseAnalytics.Event.SELECT_CONTENT,
//                    bundleOf(
//                        FirebaseAnalytics.Param.ITEM_ID to "232",
//                        FirebaseAnalytics.Param.ITEM_NAME to "Number",
//                        FirebaseAnalytics.Param.CONTENT_TYPE to "Dummy",
//                    )
//                )
//
//                //Test Crashlytics in Firebase
//              //throw RuntimeException("Test Crash") // Force a crash
//
//            }
        }


    }

    override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        if (user != null)
           goToMainActivity() //<-- this code is taking me directly to agent page instead of Login on application start
    }

     private fun goToMainActivity() {
         startActivity(Intent(this, MainActivity::class.java))
             .also { this@LoginActivity.finish() }

    }


}
