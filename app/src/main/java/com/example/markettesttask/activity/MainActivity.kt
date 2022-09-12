package com.example.markettesttask.activity

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import com.example.markettesttask.R
import com.example.core_ui.R.string.intent_action_navigate

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent !=null) {
            handleIntent(intent)
        }
    }


    private fun handleIntent(intent: Intent) {
        val navController = findNavController(R.id.global_host)
        when (intent.action) {

            getString(intent_action_navigate) -> {
                navController.navigate(R.id.myCartFragment)
                }

            else -> navController.handleDeepLink(intent)
            }
    }



}



