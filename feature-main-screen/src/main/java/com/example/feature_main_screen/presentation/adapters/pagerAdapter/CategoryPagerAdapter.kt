package com.example.feature_main_screen.presentation.adapters.pagerAdapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.feature_main_screen.presentation.model.Category
import com.example.feature_main_screen.presentation.screens.EmptyFragment
import com.example.feature_main_screen.presentation.screens.products.ProductsFragment

class CategoryPagerAdapter(
    fragment: Fragment,
    private val categories: List<Category>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = categories.size


    override fun createFragment(position: Int): Fragment =
        when(categories[position]) {

            Category.PHONES -> ProductsFragment()

            else -> EmptyFragment()
        }


}