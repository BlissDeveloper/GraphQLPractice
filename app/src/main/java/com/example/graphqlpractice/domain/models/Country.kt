package com.example.graphqlpractice.domain.models

data class Country(
    val name: String? = null,
    val capital: String? = null,
    val continent: Continent = Continent()
) {
    data class Continent(val name: String? = null)
}
