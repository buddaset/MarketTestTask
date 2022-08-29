package com.example.feature_product_details.data.mapper

import com.example.feature_product_details.data.remote.model.ProductDetailsDto
import com.example.feature_product_details.domain.model.ProductDetails


internal fun ProductDetailsDto.toDomain(): ProductDetails =
    ProductDetails(
        CPU = CPU,
        camera = camera,
        capacity = capacity,
        color = color,
        id = id,
        images = images,
        isFavorites = isFavorites,
        price = price,
        rating = rating,
        sd = sd,
        ssd = ssd,
        title = title
    )