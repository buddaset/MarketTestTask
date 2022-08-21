package com.example.feature_product_details.data.remote.source

import android.util.Log
import com.example.feature_product_details.data.remote.api.ProductDetailsApi
import com.example.feature_product_details.data.remote.model.ProductDetailsDto
import java.lang.Exception
import javax.inject.Inject

class ProductDetailsRemoteDataSourceImpl @Inject constructor(
    private val productDetailsApi: ProductDetailsApi
) : ProductDetailsRemoteDataSource {

    override suspend fun loadProductDetails(): ProductDetailsDto {

        try {
            return productDetailsApi.loadProductDetail()
        } catch (e: Exception) {
            Log.d("ProductDetail", "source ---- exception $e")
            throw e
        }

    }
}