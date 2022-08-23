package com.example.feature_product_details.presentation.adapter.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.feature_product_details.domain.model.SectionProductDetails
import com.example.feature_product_details.presentation.screens.EmptyFragment
import com.example.feature_product_details.presentation.screens.shop.ShopSectionFragment

class SectionPagerAdapter(
    fragment: Fragment,
    private val sections: List<SectionProductDetails>
): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = sections.size


    override fun createFragment(position: Int): Fragment =
        when(sections[position]) {

            SectionProductDetails.SHOP -> ShopSectionFragment()

            else -> EmptyFragment()
    }
}