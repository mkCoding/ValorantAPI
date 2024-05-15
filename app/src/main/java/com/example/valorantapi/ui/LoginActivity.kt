package com.example.valorantapi.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.valorantapi.R
import com.example.valorantapi.ui.agent.AgentsFragment
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.google.firebase.analytics.logEvent
import kotlin.math.log

class LoginActivity : AppCompatActivity() {

        private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Obtain the FirebaseAnalytics instance.
        firebaseAnalytics = Firebase.analytics


        val intent = Intent(this, MainActivity::class.java)
        val login = findViewById<Button>(R.id.btnLogin)

        login.setOnClickListener {

            //add email/password verification here [From Firebase]


            //if email and password is valid then navigate to MainActivity
            startActivity(intent)
        }


        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT) {
            param(FirebaseAnalytics.Param.ITEM_ID, "232");
            param(FirebaseAnalytics.Param.ITEM_NAME, "number");
            param(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        }

        findViewById<Button>(R.id.testCrash).setOnClickListener {

        }

    }
}