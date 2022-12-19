package com.example.graphqlpractice.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.graphqlpractice.presentation.theme.GraphQLPracticeTheme

@Composable
fun ProfileScreen() {
    Column() {
        Text(text = "Profile")
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    GraphQLPracticeTheme {
        ProfileScreen()
    }
}