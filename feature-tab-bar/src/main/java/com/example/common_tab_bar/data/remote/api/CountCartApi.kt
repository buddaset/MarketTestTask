package com.example.common_tab_bar.data.remote.api

import com.example.common_tab_bar.data.remote.model.CartResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface CountCartApi {


    @GET(CART_PATH)
    fun loadCart(): Flow<CartResponse>


    companion object{
        private  const val CART_PATH ="53539a72-3c5f-4f30-bbb1-6ca10d42c149"

    }
}