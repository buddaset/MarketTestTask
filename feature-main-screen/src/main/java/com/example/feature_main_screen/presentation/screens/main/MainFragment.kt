package com.example.feature_main_screen.presentation.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import com.example.core.common.navigation.navigate
import com.example.core.precentation.extension.onTabSelectedListener
import com.example.disneyperson.core.delegate.viewBinding
import com.example.feature_main_screen.R
import com.example.feature_main_screen.databinding.CategoryPagerItemBinding
import com.example.feature_main_screen.databinding.FragmentMainBinding
import com.example.feature_main_screen.presentation.common.model.Category
import com.example.feature_main_screen.presentation.adapters.pagerAdapter.CategoryPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding<FragmentMainBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
        setupListeners()
    }

    private fun setupViewPager() = with(binding) {
        val categories = getCategories()
        categoryViewPager.adapter = CategoryPagerAdapter(this@MainFragment, categories)

        TabLayoutMediator(
            categoryTabLayout,
            categoryViewPager) { tab, position ->
            val category = categories[position]
            val tabBinding = CategoryPagerItemBinding.inflate(
                LayoutInflater.from(categoryTabLayout.context), categoryTabLayout, false
            )

            tabBinding.titleCategory.text = category.title
            tabBinding.iconCategory.setBackgroundResource(category.iconId)
            tab.customView = tabBinding.root
        }.attach()

        categoryViewPager.isUserInputEnabled = false  // disable scroll viewpager2
    }

    private fun getCategories(): List<Category> = Category.values().toList()

    private fun setupListeners() = with(binding) {

        filterImageView.setOnClickListener {
           navigate(R.id.action_mainFragment_to_filterBottomSheetDialogFragment)

        }

        categoryTabLayout.onTabSelectedListener { tab ->
            categoryViewPager.currentItem = tab.position
        }
    }


}


