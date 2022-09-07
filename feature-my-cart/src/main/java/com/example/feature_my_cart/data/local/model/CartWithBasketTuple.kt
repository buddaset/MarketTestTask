package com.example.feature_my_cart.data.local.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.core.data.local.model.CartBasketCrossRefEntity

data class CartWithBasketTuple(
    @Embedded val cart: CartEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = CartBasketCrossRefEntity::class,
            parentColumn = "cart_id",
            entityColumn = "basket_id"
        )
    )
    val basket: List<BasketEntity>
)