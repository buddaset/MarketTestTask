package com.example.feature_main_screen.data.repository

import com.example.feature_main_screen.data.mapper.toDomain
import com.example.feature_main_screen.data.remote.source.MainScreenRemoteDataSource
import com.example.feature_main_screen.domain.model.MainScreenData
import com.example.feature_main_screen.domain.repository.MainScreenRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainScreenRepositoryImpl(private val remoteSource: MainScreenRemoteDataSource) : MainScreenRepository {

    override  fun getMainScreenData(): Flow<MainScreenData> = flow {
        val result = remoteSource.loadMainScreenData().toDomain()
        emit(result)
    }



}