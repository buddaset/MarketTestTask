package com.example.feature_main_screen.data.repository

import com.example.core.common.dispatcher.Dispatcher
import com.example.feature_main_screen.data.local.model.MainScreenDataEntityContainer
import com.example.feature_main_screen.data.local.model.isEmpty
import com.example.feature_main_screen.data.local.source.MainScreenLocalDataSource
import com.example.feature_main_screen.data.mapper.toDomain
import com.example.feature_main_screen.data.mapper.toEntity
import com.example.feature_main_screen.data.remote.source.MainScreenRemoteDataSource
import com.example.feature_main_screen.domain.model.MainScreenData
import com.example.feature_main_screen.domain.repository.MainScreenRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

internal class MainScreenRepositoryImpl @Inject constructor(
    private val remoteSource: MainScreenRemoteDataSource,
    private val localSource: MainScreenLocalDataSource,
    private val dispatcher: Dispatcher
) : MainScreenRepository {

    override fun getMainScreenData(): Flow<MainScreenData> =
        localSource.getData()
            .transform { dataEntity -> emit(checkNotEmptyAndTransformLocalData(dataEntity)) }
            .flowOn(dispatcher.io)


    private suspend fun checkNotEmptyAndTransformLocalData(data: MainScreenDataEntityContainer): MainScreenData =
        if (data.isEmpty()) loadMainScreenData()
        else data.toDomain()


    private suspend fun loadMainScreenData(): MainScreenData =
        remoteSource.loadMainScreenData()
            .onEach { dataDto -> localSource.saveData(dataDto.toEntity()) }
            .map { dataDto -> dataDto.toDomain() }
            .first()


}