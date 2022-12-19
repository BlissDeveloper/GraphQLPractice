package com.example.graphqlpractice.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.graphqlpractice.presentation.theme.GraphQLPracticeTheme

@Composable
fun NotificationsScreen() {
    Column() {
        Text(text = "Notification")
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    GraphQLPracticeTheme {
        NotificationsScreen()
    }
}