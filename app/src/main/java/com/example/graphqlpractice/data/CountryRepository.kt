package com.example.graphqlpractice.data

import com.apollographql.apollo3.api.ApolloResponse
import com.example.graphqlpractice.CountriesListQuery
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    suspend fun getAllCountries(): ApolloResponse<CountriesListQuery.Data>
}