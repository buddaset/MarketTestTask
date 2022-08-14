package com.example.feature_main_screen.domain.usecase

import com.example.feature_main_screen.domain.model.MainScreenData
import com.example.feature_main_screen.domain.repository.MainScreenRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDataMainScreenUseCase @Inject constructor(
    private val repository: MainScreenRepository) {



     operator fun invoke(): Flow<MainScreenData> =
        repository.getMainScreenData()
}