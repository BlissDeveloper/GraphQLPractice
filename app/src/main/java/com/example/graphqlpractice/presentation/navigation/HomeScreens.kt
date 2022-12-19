package com.example.graphqlpractice.presentation.navigation

sealed class HomeScreens(val route: String) {
    object CountryList : HomeScreens("country_list")
    object CountryDetails : HomeScreens("country_details")
}