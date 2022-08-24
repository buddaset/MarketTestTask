package com.example.feature_product_details.data.repository

import com.example.feature_product_details.data.mapper.toDomain
import com.example.feature_product_details.data.remote.source.ProductDetailsRemoteDataSource
import com.example.feature_product_details.domain.model.ProductDetails
import com.example.feature_product_details.domain.repository.ProductDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductDetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: ProductDetailsRemoteDataSource) : ProductDetailRepository {

    override fun getProductDetail(): Flow<ProductDetails> = flow {

        val result = remoteDataSource.loadProductDetails()
        emit(result.toDomain())
    }
}