package com.example.graphqlpractice.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.graphqlpractice.presentation.navigation.MainNavigation
import com.example.graphqlpractice.presentation.navigation.MainScreens
import com.example.graphqlpractice.presentation.theme.GraphQLPracticeTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    GraphQLPracticeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(bottomBar = { BottomBar(navController) }) {
                MainNavigation(navController)
            }
        }
    }

}

@Composable
fun BottomBar(navController: NavHostController, mainViewModel: MainViewModel = hiltViewModel()) {
    BottomNavigation() {
        BottomNavigationItem(
            label = {
                Text(text = "Home")
            },
            selected = mainViewModel.mainUiState.value.selectedBottomOption == MainScreens.Home.route,
            onClick = {
                navController.navigate(MainScreens.Home.route)
                mainViewModel.setCurrentNav(MainScreens.Home)
            },
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "") })
        BottomNavigationItem(
            label = {
                Text(text = "Notifications")
            },
            selected = mainViewModel.mainUiState.value.selectedBottomOption == MainScreens.Notifications.route,
            onClick = {
                navController.navigate(MainScreens.Notifications.route)
                mainViewModel.setCurrentNav(MainScreens.Notifications)
            },
            icon = { Icon(imageVector = Icons.Filled.Notifications, contentDescription = "") })
        BottomNavigationItem(
            label = {
                Text(text = "Profile")
            },
            selected = mainViewModel.mainUiState.value.selectedBottomOption == MainScreens.Profile.route,
            onClick = {
                navController.navigate(MainScreens.Profile.route)
                mainViewModel.setCurrentNav(MainScreens.Profile)
            },
            icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "") })
    }
}