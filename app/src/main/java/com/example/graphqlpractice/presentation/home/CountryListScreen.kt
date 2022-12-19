package com.example.graphqlpractice.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.graphqlpractice.domain.models.Country
import com.example.graphqlpractice.presentation.navigation.HomeScreens
import com.example.graphqlpractice.presentation.theme.GraphQLPracticeTheme

@Composable
fun CountryListScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val uiState = homeViewModel.homeUiState.value
    if (uiState.isLoading) {
        CircularProgressIndicator()
    } else {
        CountryList(countryList = uiState.countries)
        LaunchedEffect(key1 = uiState.isToNavigate) {
            if (uiState.isToNavigate) {
                navController.navigate(HomeScreens.CountryDetails.route)
                homeViewModel.setIsToNavigate(false)
            }
        }
    }
}

@Composable
fun CountryList(countryList: List<HomeUiState.CountryItemUiState>) {
    LazyColumn() {
        items(countryList) { countryUiState ->
            CountryCard(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                countryItemUiState = countryUiState
            )
        }
    }
}

@Composable
fun CountryCard(modifier: Modifier = Modifier, countryItemUiState: HomeUiState.CountryItemUiState) {
    Card(modifier = modifier
        .clickable {
            countryItemUiState.onClicked()
        }
        .fillMaxWidth()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = countryItemUiState.country?.name.orEmpty()
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun CountryListScreenPreview() {
    GraphQLPracticeTheme {
        CountryList(
            countryList = listOf(
                HomeUiState.CountryItemUiState(
                    country = Country(name = "Philippines")
                ), HomeUiState.CountryItemUiState(
                    country = Country(name = "USA")
                )
            )
        )
    }
}