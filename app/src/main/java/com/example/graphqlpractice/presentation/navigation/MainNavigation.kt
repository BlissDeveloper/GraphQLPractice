package com.example.graphqlpractice.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.graphqlpractice.presentation.NotificationsScreen
import com.example.graphqlpractice.presentation.home.CountryListScreen
import com.example.graphqlpractice.presentation.home.details.CountryDetailsScreen
import com.example.graphqlpractice.presentation.profile.ProfileScreen

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MainScreens.Home.route) {
        homeGraph(navController)
        composable(route = MainScreens.Notifications.route) {
            NotificationsScreen()
        }
        composable(route = MainScreens.Profile.route) {
            ProfileScreen()
        }
        composable(route = HomeScreens.CountryDetails.route) {
            CountryDetailsScreen()
        }
    }
}

fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation(startDestination = HomeScreens.CountryList.route, route = MainScreens.Home.route) {
        composable(route = HomeScreens.CountryList.route) {
            CountryListScreen(navController)
        }

    }
}