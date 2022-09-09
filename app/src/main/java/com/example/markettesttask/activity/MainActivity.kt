package com.example.markettesttask.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.markettesttask.R
import com.example.markettesttask.databinding.ActivityMainBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity(R.layout.activity_main) {


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent !=null)
            handle(intent)
    }


    private fun handle(intent: Intent) {
        when (intent.action) {

            Intent.ACTION_VIEW -> {
                findNavController(R.id.global_host).navigate(R.id.myCartFragment)
                }
            }
    }

}



