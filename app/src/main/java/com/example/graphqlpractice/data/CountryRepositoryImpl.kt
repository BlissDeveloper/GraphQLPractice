package com.example.graphqlpractice.data

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.example.graphqlpractice.CountriesListQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(private val apolloClient: ApolloClient) :
    CountryRepository {

    override suspend fun getAllCountries(): ApolloResponse<CountriesListQuery.Data> {
        return apolloClient.query(CountriesListQuery()).execute()
    }
}