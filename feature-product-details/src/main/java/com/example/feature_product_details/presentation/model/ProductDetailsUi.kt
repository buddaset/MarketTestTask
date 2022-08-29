package com.example.feature_product_details.presentation.model

import com.example.feature_product_details.domain.model.ProductDetails
import java.text.DecimalFormat

internal data class ProductDetailsUi(
    val CPU: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val id: String,
    val images: List<String>,
    val isFavorites: Boolean,
    val price: String,
    val rating: Float,
    val sd: String,
    val ssd: String,
    val title: String

)


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
