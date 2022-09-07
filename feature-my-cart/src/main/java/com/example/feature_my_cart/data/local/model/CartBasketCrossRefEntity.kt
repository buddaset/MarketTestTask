package com.example.feature_my_cart.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(tableName = "carts_baskets_cross_ref",
primaryKeys = ["cart_id", "basket_id"])
data class CartBasketCrossRefEntity(
    @ColumnInfo(name="cart_id") val  cartId: String,
    @ColumnInfo(name="basket_id")val basketId: Int
)