package com.example.feature_main_screen.data.repository

import android.util.Log
import com.example.feature_main_screen.data.mapper.toDomain
import com.example.feature_main_screen.data.remote.source.MainScreenRemoteDataSource
import com.example.feature_main_screen.domain.model.MainScreenData
import com.example.feature_main_screen.domain.repository.MainScreenRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainScreenRepositoryImpl @Inject constructor(
    private val remoteSource: MainScreenRemoteDataSource
) : MainScreenRepository {

    override fun getMainScreenData(): Flow<MainScreenData> = flow {

        val result = remoteSource.loadMainScreenData()
        Log.d("MainFragment", "repo ----${result.bestSeller}")

        emit(result.toDomain())
    }.flowOn(Dispatchers.IO)


}