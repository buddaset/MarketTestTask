package com.example.feature_product_details.data.repository

import com.example.core.common.dispatcher.Dispatcher
import com.example.feature_product_details.data.local.model.ProductDetailsEntity
import com.example.feature_product_details.data.local.source.ProductDetailsLocalDataSource
import com.example.feature_product_details.data.mapper.toDomain
import com.example.feature_product_details.data.mapper.toEntity
import com.example.feature_product_details.data.remote.model.ProductDetailsDto
import com.example.feature_product_details.data.remote.source.ProductDetailsRemoteDataSource
import com.example.feature_product_details.domain.model.ProductDetails
import com.example.feature_product_details.domain.repository.ProductDetailRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

internal class ProductDetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: ProductDetailsRemoteDataSource,
    private val localDataSource: ProductDetailsLocalDataSource,
    private val dispatcher: Dispatcher
) : ProductDetailRepository {

    override fun getProductDetails(): Flow<ProductDetails> =
        localDataSource.getProductDetails()
            .onEmpty { loadProductDetails() }
            .map {  productDetailsEntity -> productDetailsEntity.toDomain() }
            .flowOn(dispatcher.io)


    private suspend fun loadProductDetails(): ProductDetails =
        remoteDataSource.loadProductDetails()
            .onEach { productDetailsDto -> localDataSource.save(productDetailsDto.toEntity()) }
            .map { productDetailsDto -> productDetailsDto.toDomain() }
            .first()
}