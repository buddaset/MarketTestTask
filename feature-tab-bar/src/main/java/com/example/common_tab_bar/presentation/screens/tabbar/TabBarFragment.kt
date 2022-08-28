package com.example.common_tab_bar.presentation.screens.tabbar

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.common_tab_bar.R
import com.example.common_tab_bar.databinding.FragmentTabBarBinding
import com.example.common_tab_bar.di.TabBarComponentViewModel
import com.example.common_tab_bar.domain.model.CountCartItem
import com.example.common_tab_bar.presentation.factory.ViewModelFactory
import com.example.core.precentation.extension.collectFlow
import com.example.disneyperson.core.delegate.viewBinding
import javax.inject.Inject


class TabBarFragment : Fragment(R.layout.fragment_tab_bar) {

    private val binding: FragmentTabBarBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: TabBarViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<TabBarComponentViewModel>().tabBarComponent.inject(this)
        super.onAttach(context)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setupBottomNavigation()


        collectFlow(viewModel.countCartItem, ::updateMyCartBadge)


    }

    override fun onStart() {
        super.onStart()
        setMainScreenBottomNavigationViewOnStart()

    }

    private fun setMainScreenBottomNavigationViewOnStart(){
        binding.bottomNavView.selectedItemId = com.example.feature_main_screen.R.id.main_screen_graph


    }




    private fun updateMyCartBadge(countCartItem: CountCartItem) {
        if (countCartItem.count == 0) return
        val myCartBadge = binding.bottomNavView.getOrCreateBadge(R.id.myCartFragment)
        myCartBadge.number= countCartItem.count
        

    }


    private fun setupBottomNavigation() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.tab_bar_host) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavView.setupWithNavController(navController)


        setupSelectedListener()

    }

    private fun setupSelectedListener() {

        binding.bottomNavView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.myCartFragment -> findNavController().navigate(R.id.myCartFragment)
            }
            true
        }

    }



}




