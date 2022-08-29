package com.example.feature_my_cart.data.mapper

import com.example.feature_my_cart.data.remote.model.BasketDto
import com.example.feature_my_cart.data.remote.model.CartDto
import com.example.feature_my_cart.domain.model.Basket
import com.example.feature_my_cart.domain.model.Cart


internal fun CartDto.toDomain(): Cart =
    Cart(
        basket = basket.toDomain(),
        delivery = delivery,
        id = id,
        total = total
    )

internal fun List<BasketDto>.toDomain(): List<Basket> =
    this.map { basketDto -> basketDto.toDomain() }


internal fun BasketDto.toDomain(): Basket =
    Basket(
        id = id,
        images = images,
        price = price,
        title = title
    )