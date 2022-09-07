package com.example.feature_product_details.data.repository

import com.example.core.common.dispatcher.Dispatcher
import com.example.feature_product_details.data.local.model.ProductDetailsEntity
import com.example.feature_product_details.data.local.source.ProductDetailsLocalDataSource
import com.example.feature_product_details.data.mapper.toDomain
import com.example.feature_product_details.data.mapper.toEntity
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

    override fun getProductDetails(): Flow<ProductDetails> = localDataSource.getProductDetails()
            .transform { productDetailsEntity -> emit(checkEmptyLocalSource(productDetailsEntity)) }
            .flowOn(dispatcher.io)


    private suspend fun checkEmptyLocalSource(data: ProductDetailsEntity?) : ProductDetails =
        data?.toDomain() ?: loadAndSaveProductDetails().toDomain()

    private suspend fun loadAndSaveProductDetails(): ProductDetailsEntity =
        remoteDataSource.loadProductDetails()
            .map { productDetailsDto -> productDetailsDto.toEntity() }
            .onEach { productDetailsEntity -> localDataSource.save(productDetailsEntity) }
            .first()
}