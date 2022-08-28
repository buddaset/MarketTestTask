package com.example.feature_main_screen.presentation.model

import com.example.feature_main_screen.presentation.adapters.delegateAdapter.ItemUi


internal data class BestSellerUi(
    val discountPrice: Int,
    val id: Int,
    val isFavorites: Boolean,
    val picture: String,
    val priceWithoutDiscount: Int,
    val title: String
) : ItemUi {
    override val itemId: Long = id.toLong()
}
