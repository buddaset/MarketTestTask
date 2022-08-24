package com.example.feature_product_details.domain.repository

import com.example.feature_product_details.domain.model.ProductDetails
import kotlinx.coroutines.flow.Flow

interface ProductDetailRepository {


    fun getProductDetail(): Flow<ProductDetails>
}