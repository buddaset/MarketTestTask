package com.example.feature_main_screen.data.remote.source

import com.example.feature_main_screen.data.remote.api.MainScreenApi
import com.example.feature_main_screen.data.remote.model.MainScreenDataDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class MainScreenRemoteDataSourceImpl @Inject constructor(
    private val mainScreenApi: MainScreenApi
) : MainScreenRemoteDataSource {

    override  fun loadMainScreenData(): Flow<MainScreenDataDto> =
        mainScreenApi.loadMainScreenData()

}