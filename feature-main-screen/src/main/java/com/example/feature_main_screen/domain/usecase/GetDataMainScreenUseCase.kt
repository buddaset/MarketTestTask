package com.example.feature_main_screen.domain.usecase

import com.example.feature_main_screen.domain.model.MainScreenData
import com.example.feature_main_screen.domain.repository.MainScreenRepository

class GetDataMainScreenUseCase(private val repository: MainScreenRepository) {



    suspend operator fun invoke(): MainScreenData =
        repository.getMainScreenData()
}