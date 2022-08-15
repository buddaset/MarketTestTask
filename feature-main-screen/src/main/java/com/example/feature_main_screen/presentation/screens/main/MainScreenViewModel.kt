package com.example.feature_main_screen.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.precentation.UiState
import com.example.feature_main_screen.domain.model.MainScreenData
import com.example.feature_main_screen.domain.usecase.GetDataMainScreenUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*


internal class MainScreenViewModel( getDataMainScreenUseCase: GetDataMainScreenUseCase ) : ViewModel() {



    @OptIn(ExperimentalCoroutinesApi::class)
    val data: StateFlow<UiState<MainScreenData>> =
        getDataMainScreenUseCase()
            .catch { error -> UiState.Error<MainScreenData>(error = error) }
            .mapLatest { data -> UiState.Success(data = data) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = UiState.Loading()
            )




}