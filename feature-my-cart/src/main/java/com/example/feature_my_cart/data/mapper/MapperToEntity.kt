package com.example.feature_my_cart.data.mapper

import com.example.feature_my_cart.data.local.model.BasketEntity
import com.example.feature_my_cart.data.local.model.CartEntity
import com.example.feature_my_cart.data.remote.model.BasketDto
import com.example.feature_my_cart.data.remote.model.CartDto


internal fun CartDto.toEntity(): CartEntity =
    CartEntity(
        basket = basket.toEntity(),
        delivery = delivery,
        id = id,
        total = total
    )

internal fun List<BasketDto>.toEntity(): List<BasketEntity> =
    this.map { basketEntity -> basketEntity.toEntity() }


internal fun BasketDto.toEntity(): BasketEntity =
    BasketEntity(
        id = id,
        images = images,
        price = price,
        title = title
    )