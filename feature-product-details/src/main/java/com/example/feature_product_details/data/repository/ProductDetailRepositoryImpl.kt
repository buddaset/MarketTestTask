package com.example.feature_product_details.data.repository

import com.example.core.common.dispatcher.Dispatcher
import com.example.feature_product_details.data.mapper.toDomain
import com.example.feature_product_details.data.remote.model.ProductDetailsDto
import com.example.feature_product_details.data.remote.source.ProductDetailsRemoteDataSource
import com.example.feature_product_details.domain.model.ProductDetails
import com.example.feature_product_details.domain.repository.ProductDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductDetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: ProductDetailsRemoteDataSource,
 private val dispatcher: Dispatcher) : ProductDetailRepository {

    override fun getProductDetail(): Flow<ProductDetails> =
        remoteDataSource.loadProductDetails()
            .map {  productDetailsDto -> productDetailsDto.toDomain()  }
            .flowOn(dispatcher.io)
}