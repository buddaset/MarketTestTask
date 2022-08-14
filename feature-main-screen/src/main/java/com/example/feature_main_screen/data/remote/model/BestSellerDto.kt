package com.example.feature_main_screen.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BestSellerDto(
    @SerialName("discount_price") val discountPrice: Int,
    @SerialName("id") val id: Int,
    @SerialName("is_favorites") val isFavorites: Boolean = false,
    @SerialName("picture") val picture: String,
    @SerialName("price_without_discount") val priceWithoutDiscount: Int,
    @SerialName("title") val title: String
)