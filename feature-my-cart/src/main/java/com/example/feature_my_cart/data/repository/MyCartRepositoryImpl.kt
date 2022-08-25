package com.example.feature_my_cart.data.repository

import com.example.feature_my_cart.data.mapper.toDomain
import com.example.feature_my_cart.data.remote.source.MyCartRemoteDataSource
import com.example.feature_my_cart.domain.model.Cart
import com.example.feature_my_cart.domain.repository.MyCartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MyCartRepositoryImpl @Inject constructor(
    private val remoteDataSource: MyCartRemoteDataSource) : MyCartRepository {

    override fun getMyCart(): Flow<Cart> =
        remoteDataSource.loadMyCart()
            .map { cartDto -> cartDto.toDomain() }

}