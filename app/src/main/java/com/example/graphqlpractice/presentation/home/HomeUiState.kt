package com.example.graphqlpractice.presentation.home

import com.example.graphqlpractice.domain.models.Country


data class HomeUiState(
    val countries: List<CountryItemUiState> = listOf(),
    val message: MessageUiState = MessageUiState(),
    val isLoading: Boolean = false,
    val isToNavigate: Boolean = false
) {
    data class CountryItemUiState(
        val country: Country? = null,
        val onClicked:  () -> Unit = {}
    )

    data class MessageUiState(
        val message: String? = null,
        val isError: Boolean = false
    )
}