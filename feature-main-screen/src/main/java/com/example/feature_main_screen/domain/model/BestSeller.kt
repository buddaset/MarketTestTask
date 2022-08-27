package com.example.feature_main_screen.domain.model

import com.example.feature_main_screen.presentation.adapters.delegateAdapter.ItemUi

internal data class BestSeller(
    val discountPrice: Int,
    val id: Int,
    val isFavorites: Boolean,
    val picture: String,
    val priceWithoutDiscount: Int,
    val title: String
) : ItemUi {
    override val itemId: Long = id.toLong()
}
