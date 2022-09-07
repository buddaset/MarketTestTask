package com.example.feature_main_screen.data.local.source

import com.example.feature_main_screen.data.local.dao.MainScreenDataDao
import com.example.feature_main_screen.data.local.model.MainScreenDataEntityContainer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

 internal class MainScreenLocalDataSourceImpl @Inject constructor(
    private val mainScreenDataDao: MainScreenDataDao
) : MainScreenLocalDataSource {

    override suspend fun saveData(data: MainScreenDataEntityContainer) {
        mainScreenDataDao.insertData(data)
    }

    override fun getData(): Flow<MainScreenDataEntityContainer> = flow {

        emit(mainScreenDataDao.getData())
    }
}
