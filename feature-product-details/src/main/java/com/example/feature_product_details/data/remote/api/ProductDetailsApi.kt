package com.example.feature_product_details.data.remote.api

import com.example.feature_product_details.data.remote.model.ProductDetailsDto
import retrofit2.http.GET

interface ProductDetailsApi {


    @GET(PRODUCT_DETAIL_PATH)
    suspend fun loadProductDetail(): ProductDetailsDto


    companion object {

        const val PRODUCT_DETAIL_PATH ="6c14c560-15c6-4248-b9d2-b4508df7d4f5"
    }
}