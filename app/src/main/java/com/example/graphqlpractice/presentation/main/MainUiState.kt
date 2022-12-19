package com.example.graphqlpractice.presentation.main

import com.example.graphqlpractice.presentation.navigation.MainScreens

data class MainUiState(
    val selectedBottomOption: String =  MainScreens.Home.route
)