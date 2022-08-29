package com.example.feature_product_details.data.remote.source

import com.example.feature_product_details.data.remote.model.ProductDetailsDto
import kotlinx.coroutines.flow.Flow

internal interface ProductDetailsRemoteDataSource {

     fun loadProductDetails(): Flow<ProductDetailsDto>
}