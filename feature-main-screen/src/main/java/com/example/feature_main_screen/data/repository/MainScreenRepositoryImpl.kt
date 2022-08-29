package com.example.feature_main_screen.data.repository

import com.example.core.common.dispatcher.Dispatcher
import com.example.feature_main_screen.data.mapper.toDomain
import com.example.feature_main_screen.data.remote.source.MainScreenRemoteDataSource
import com.example.feature_main_screen.domain.model.MainScreenData
import com.example.feature_main_screen.domain.repository.MainScreenRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class MainScreenRepositoryImpl @Inject constructor(
    private val remoteSource: MainScreenRemoteDataSource,
    private val dispatcher: Dispatcher
) : MainScreenRepository {

    override fun getMainScreenData(): Flow<MainScreenData> =
        remoteSource.loadMainScreenData()
            .map { dataDto -> dataDto.toDomain() }
            .flowOn(dispatcher.io)

}