package com.example.feature_main_screen.presentation.model

import com.example.feature_main_screen.domain.model.BestSeller
import com.example.feature_main_screen.presentation.adapters.delegateAdapter.ItemUi



internal data class BestSellersItemsUi(
    val title: String = "Best Seller",
    val bestSellers: List<BestSeller>
) : ItemUi {
    override val itemId: Long = title.hashCode().toLong()
}
