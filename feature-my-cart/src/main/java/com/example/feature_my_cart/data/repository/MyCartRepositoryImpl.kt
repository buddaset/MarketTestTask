package com.example.feature_my_cart.data.repository

import com.example.core.common.dispatcher.Dispatcher
import com.example.feature_my_cart.data.local.model.CartWithBasketTuple
import com.example.feature_my_cart.data.local.source.MyCartLocalDataSource
import com.example.feature_my_cart.data.mapper.toDomain
import com.example.feature_my_cart.data.mapper.toEntity
import com.example.feature_my_cart.data.remote.model.CartDto
import com.example.feature_my_cart.data.remote.source.MyCartRemoteDataSource
import com.example.feature_my_cart.domain.model.Cart
import com.example.feature_my_cart.domain.repository.MyCartRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

internal class MyCartRepositoryImpl @Inject constructor(
    private val remoteDataSource: MyCartRemoteDataSource,
    private val localDataSource: MyCartLocalDataSource,
    private val dispatcher: Dispatcher
) : MyCartRepository {

    override fun getMyCart(): Flow<Cart> =
        localDataSource.getMyCart()
            .transform { cartEntity -> emit(checkNullAndTransformData(cartEntity)) }
            .flowOn(dispatcher.io)


    private suspend fun checkNullAndTransformData(data: CartWithBasketTuple?): Cart =
        data?.toDomain() ?: loadAndSaveData().toDomain()


    private suspend fun loadAndSaveData(): CartDto =
        remoteDataSource.loadMyCart()
            .onEach { cartDto -> localDataSource.save(cartDto.toEntity()) }
            .first()


}