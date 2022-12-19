package com.example.graphqlpractice.domain

import com.example.graphqlpractice.data.CountryRepository
import com.example.graphqlpractice.domain.models.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import okhttp3.Dispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCountriesListUseCase @Inject constructor(private val countryRepository: CountryRepository) {
    suspend fun execute(): Flow<List<Country>> {
        return flow {
            emit(countryRepository.getAllCountries())
        }.map { response ->
            val countries = mutableListOf<Country>()
            response.data?.countries?.forEach {
                countries.add(
                    Country(
                        name = it.name, capital = it.capital, continent = Country.Continent(
                            name = it.continent.name
                        )
                    )
                )
            }
            return@map countries
        }
    }
}