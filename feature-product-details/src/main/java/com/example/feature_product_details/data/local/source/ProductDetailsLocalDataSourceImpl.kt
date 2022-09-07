package com.example.feature_product_details.data.local.source

import com.example.feature_product_details.data.local.dao.ProductDetailsDao
import com.example.feature_product_details.data.local.model.ProductDetailsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductDetailsLocalDataSourceImpl @Inject constructor(
    private val productDetailsDao: ProductDetailsDao
): ProductDetailsLocalDataSource {


    override suspend fun save(data: ProductDetailsEntity) {
        productDetailsDao.insert(data)
    }

    override fun getProductDetails(): Flow<ProductDetailsEntity> =
        productDetailsDao.getProductDetails()


}