package com.example.graphqlpractice.presentation.home.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.graphqlpractice.presentation.theme.GraphQLPracticeTheme

@Composable
fun CountryDetailsScreen() {
    Column() {
        Text(text = "Country details")
    }
}

@Composable
@Preview(showBackground = true)
fun CountryDetailsScreenPreview() {
    GraphQLPracticeTheme {
        CountryDetailsScreen()
    }
}