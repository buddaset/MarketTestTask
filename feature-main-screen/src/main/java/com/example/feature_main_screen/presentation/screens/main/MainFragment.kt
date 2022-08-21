package com.example.feature_main_screen.presentation.screens.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.disneyperson.core.delegate.viewBinding
import com.example.feature_main_screen.R
import com.example.feature_main_screen.databinding.CategoryPagerItemBinding
import com.example.feature_main_screen.databinding.FragmentMainBinding
import com.example.feature_main_screen.di.MainScreenComponentViewModel
import com.example.feature_main_screen.domain.model.Category
import com.example.feature_main_screen.presentation.adapters.pagerAdapter.CategoryPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment(R.layout.fragment_main) {


    private val binding by viewBinding<FragmentMainBinding>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPageAdapter()
        setupSelectedListenerForTabLayout()
        setupListener()
    }

    private fun setupListener() = with(binding) {
        filterImageView.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_filterBottomSheetDialogFragment)
        }

        viewAllTextView.setOnClickListener {
            requireActivity().findNavController(com.example.core.R.id.nav_host_fragment)
                .navigate(com.example.core.R.id.action_tabBarFragment_to_testFragment)
        }
    }


    private fun setupPageAdapter() = with(binding) {
        val categories = getCategories()
        categoryViewPager.adapter = CategoryPagerAdapter(this@MainFragment, categories)

        TabLayoutMediator(
            categoryTabLayout,
            categoryViewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                val category = categories[position]
                val tabBinding = CategoryPagerItemBinding.inflate(
                    LayoutInflater.from(categoryTabLayout.context), categoryTabLayout, false
                )

                tabBinding.titleCategory.text = category.title
                tabBinding.iconCategory.setBackgroundResource(category.iconId)
                tab.customView = tabBinding.root
            }).attach()

        categoryViewPager.isUserInputEnabled = false  // disable scroll viewpager2

    }

    private fun getCategories(): List<Category> = Category.values().toList()

    //todo write extension for selectedListener

    /*
    DIFFuTIL И РЕФАфакторинг для адаптеров
    доводка адаптера до сдледующего елемента, чтобы не застревал по середине
    работа с состояниями
    дописать обработчик в дата слое
    создать модели для адаптера в пресентейшен слое
    подключение кнопок


     */

    private fun setupSelectedListenerForTabLayout() {
        binding.categoryTabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.categoryViewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

}