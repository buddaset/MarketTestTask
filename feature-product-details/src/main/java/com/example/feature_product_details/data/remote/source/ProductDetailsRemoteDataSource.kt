package com.example.feature_product_details.data.remote.source

import com.example.feature_product_details.data.remote.model.ProductDetailsDto

interface ProductDetailsRemoteDataSource {

    suspend fun loadProductDetails(): ProductDetailsDto
}