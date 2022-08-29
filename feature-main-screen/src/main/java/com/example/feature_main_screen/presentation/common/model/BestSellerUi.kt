package com.example.feature_main_screen.presentation.common.model

import com.example.feature_main_screen.presentation.adapters.delegateAdapter.ItemUi


internal data class BestSellerUi(
    val discountPrice: String,
    val id: Int,
    val isFavorites: Boolean,
    val picture: String,
    val priceWithoutDiscount: String,
    val title: String
) : ItemUi {
    override val itemId: Long = id.toLong()
}
