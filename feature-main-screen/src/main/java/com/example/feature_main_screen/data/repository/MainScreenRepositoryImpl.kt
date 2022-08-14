package com.example.feature_main_screen.data.repository

import com.example.feature_main_screen.data.mapper.toDomain
import com.example.feature_main_screen.data.remote.source.MainScreenRemoteDataSource
import com.example.feature_main_screen.domain.model.MainScreenData
import com.example.feature_main_screen.domain.repository.MainScreenRepository

class MainScreenRepositoryImpl(private val remoteSource: MainScreenRemoteDataSource) : MainScreenRepository {

    override suspend fun getMainScreenData(): MainScreenData =
        remoteSource.loadMainScreenData().toDomain()


}