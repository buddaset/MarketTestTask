package com.example.feature_product_details.domain.usecase

import com.example.feature_product_details.domain.model.ProductDetails
import com.example.feature_product_details.domain.repository.ProductDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetProductDetailsUseCase @Inject constructor(
    private val repository: ProductDetailRepository) {
    
    operator fun invoke(): Flow<ProductDetails> =
        repository.getProductDetails()
}