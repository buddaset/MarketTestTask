package com.example.feature_my_cart.presentation.common.mapper

import com.example.feature_my_cart.domain.model.Basket
import com.example.feature_my_cart.domain.model.Cart
import com.example.feature_my_cart.presentation.common.model.BasketUi
import com.example.feature_my_cart.presentation.common.model.CartUi
import java.text.DecimalFormat


internal fun Cart.toUi(): CartUi =
    CartUi(
        basket = basket.toUi(),
        delivery = delivery,
        id = id,
        total = formatPriceTotal(total)
    )

internal fun List<Basket>.toUi(): List<BasketUi> =
    this.map { basket -> basket.toUi() }


internal fun Basket.toUi(): BasketUi =
    BasketUi(
        id = id,
        images = images,
        price = formatPriceItem(price),
        title = title
    )


internal fun formatPriceItem(price: Int): String =
    DecimalFormat(".00").format(price)

internal fun formatPriceTotal(price: Int): String =
    DecimalFormat("#,###").format(price)