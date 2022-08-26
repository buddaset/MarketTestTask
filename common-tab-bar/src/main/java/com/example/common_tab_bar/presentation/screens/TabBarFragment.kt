package com.example.common_tab_bar.presentation.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.common_tab_bar.R
import com.example.common_tab_bar.databinding.FragmentTabBarBinding
import com.example.disneyperson.core.delegate.viewBinding



class TabBarFragment : Fragment(R.layout.fragment_tab_bar) {

    private val binding: FragmentTabBarBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomNavigation()


    }

    private fun setupBottomNavigation() {

        val navHostFragment = childFragmentManager.findFragmentById(R.id.tab_bar_host) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavView.setupWithNavController(navController)

        binding.bottomNavView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {

                R.id.myCartFragment -> findNavController().navigate(R.id.myCartFragment)
            }
            true
        }



        val badge = binding.bottomNavView.getOrCreateBadge(R.id.myCartFragment)
        badge.isVisible
        badge.number = 2


    }



}

