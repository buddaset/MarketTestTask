package com.example.feature_main_screen.data.remote.source

import com.example.feature_main_screen.data.mapper.toDomain
import com.example.feature_main_screen.data.remote.MainScreenApi
import com.example.feature_main_screen.data.remote.model.MainScreenDataDto

class MainScreenRemoteDataSourceImpl(private val mainScreenApi: MainScreenApi) : MainScreenRemoteDataSource {
    override suspend fun loadMainScreenData(): MainScreenDataDto =
        mainScreenApi.loadMainScreenData()



}