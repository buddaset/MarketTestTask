package com.example.feature_my_cart.data.mapper

import com.example.feature_my_cart.data.remote.model.BasketDto
import com.example.feature_my_cart.data.remote.model.CartDto
import com.example.feature_my_cart.domain.model.Basket
import com.example.feature_my_cart.domain.model.Cart


fun CartDto.toDomain(): Cart =
    Cart(
        basket = basket.toDomain(),
        delivery = delivery,
        id = id,
        total = total
    )

fun List<BasketDto>.toDomain(): List<Basket> =
    this.map { basketDto -> basketDto.toDomain() }


fun BasketDto.toDomain(): Basket =
    Basket(
        id = id,
        images = images,
        price = price,
        title = title
    )