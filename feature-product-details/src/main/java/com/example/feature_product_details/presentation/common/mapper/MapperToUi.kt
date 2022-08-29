package com.example.feature_product_details.presentation.common.mapper

import com.example.feature_product_details.domain.model.ProductDetails
import com.example.feature_product_details.presentation.common.model.ProductDetailsUi
import java.text.DecimalFormat


internal fun ProductDetails.toUi(): ProductDetailsUi =
    ProductDetailsUi(
        CPU = CPU,
        camera = camera,
        capacity = capacity,
        color = color,
        id = id,
        images = images,
        isFavorites = isFavorites,
        price = formatPrice(price),
        rating = rating.toFloat(),
        sd = sd,
        ssd = ssd,
        title = title
    )

internal fun formatPrice(price: Int): String =
    DecimalFormat("#,###.00").format(price)
