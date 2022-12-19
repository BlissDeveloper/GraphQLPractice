package com.example.graphqlpractice.presentation.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.graphqlpractice.presentation.navigation.MainScreens
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    private val _mainUiState = mutableStateOf(MainUiState())
    val mainUiState = _mainUiState

    fun setCurrentNav(screen: MainScreens) {
        _mainUiState.value = _mainUiState.value.copy(
            selectedBottomOption = screen.route
        )
    }
}