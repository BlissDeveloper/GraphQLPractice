package com.example.graphqlpractice.di

import com.example.graphqlpractice.data.CountryRepository
import com.example.graphqlpractice.data.CountryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindCountryRepository(countryRepositoryImpl: CountryRepositoryImpl): CountryRepository
}
