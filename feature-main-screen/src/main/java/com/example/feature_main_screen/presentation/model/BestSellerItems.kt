package com.example.feature_main_screen.presentation.model

import com.example.feature_main_screen.presentation.adapters.delegateAdapter.ItemUi


internal data class BestSellerItemsUi(
    val title: String = "Best Seller",
    val bestSellers: List<BestSellerUi>
) : ItemUi {
    override val itemId: Long = title.hashCode().toLong()
}
