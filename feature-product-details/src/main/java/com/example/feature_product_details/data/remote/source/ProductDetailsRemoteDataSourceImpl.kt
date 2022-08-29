package com.example.feature_product_details.data.remote.source

import com.example.feature_product_details.data.remote.api.ProductDetailsApi
import com.example.feature_product_details.data.remote.model.ProductDetailsDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class ProductDetailsRemoteDataSourceImpl @Inject constructor(
    private val productDetailsApi: ProductDetailsApi
) : ProductDetailsRemoteDataSource {

    override fun loadProductDetails(): Flow<ProductDetailsDto> =
        productDetailsApi.loadProductDetail()


}