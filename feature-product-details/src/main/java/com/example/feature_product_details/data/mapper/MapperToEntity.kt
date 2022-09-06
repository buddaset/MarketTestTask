package com.example.feature_product_details.data.mapper

import com.example.feature_product_details.data.local.model.ProductDetailsEntity
import com.example.feature_product_details.data.remote.model.ProductDetailsDto


internal fun ProductDetailsDto.toEntity(): ProductDetailsEntity =
    ProductDetailsEntity(
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