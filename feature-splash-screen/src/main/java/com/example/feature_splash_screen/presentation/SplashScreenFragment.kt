package com.example.feature_splash_screen.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.feature_splash_screen.R

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.postDelayed({
            findNavController().navigate(R.id.action_splashScreenFragment_to_tabBarFragment)
        }, POST_DELAY_TIME)
    }


    companion object {

        const val POST_DELAY_TIME =2000L
    }


}