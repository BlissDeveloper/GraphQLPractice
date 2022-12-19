package com.example.graphqlpractice.presentation.navigation

sealed class MainScreens(val route: String) {
    object Home: MainScreens("home")
    object Notifications: MainScreens("notifications")
    object Profile: MainScreens("profile")
}