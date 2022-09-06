package com.example.feature_product_details.data.local.source

import com.example.feature_product_details.data.local.model.ProductDetailsEntity
import kotlinx.coroutines.flow.Flow

interface ProductDetailsLocalDataSource {

    suspend fun save(data: ProductDetailsEntity)

    fun getProductDetails(): Flow<ProductDetailsEntity>
}