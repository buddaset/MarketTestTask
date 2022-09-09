package com.example.markettesttask.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.markettesttask.R

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



