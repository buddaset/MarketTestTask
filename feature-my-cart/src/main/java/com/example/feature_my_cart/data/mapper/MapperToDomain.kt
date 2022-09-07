package com.example.feature_my_cart.data.mapper

import com.example.feature_my_cart.data.local.model.BasketEntity
import com.example.feature_my_cart.data.local.model.CartWithBasketTuple
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



internal fun CartWithBasketTuple.toDomain(): Cart =
    Cart(
        id = cart.id,
        basket = basket.toDomain(),
        delivery = cart.delivery,
        total = cart.total
    )


@JvmName("toDomainBasketEntity")
internal fun List<BasketEntity>.toDomain(): List<Basket> =
    this.map { basketEntity -> basketEntity.toDomain() }


internal fun BasketEntity.toDomain(): Basket =
    Basket(
        id = id,
        images = images,
        price = price,
        title = title
    )