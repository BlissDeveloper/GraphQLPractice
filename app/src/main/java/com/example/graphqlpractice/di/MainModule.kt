package com.example.graphqlpractice.di

import com.apollographql.apollo3.ApolloClient
import com.example.graphqlpractice.data.CountryRepository
import com.example.graphqlpractice.data.CountryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
 class MainModule {
    @Provides
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder().serverUrl("https://countries.trevorblades.com/").build()
    }

    @Provides
    fun provideCountryRepository(apolloClient: ApolloClient): CountryRepositoryImpl {
        return CountryRepositoryImpl(apolloClient)
    }


}