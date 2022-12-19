package com.example.graphqlpractice.presentation.home

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqlpractice.domain.GetCountriesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getCountriesListUseCase: GetCountriesListUseCase) :
    ViewModel() {
    private val _homeUiState = mutableStateOf(HomeUiState())
    val homeUiState = _homeUiState

    init {
        getCountryList()
    }

    private fun getCountryList() {
        _homeUiState.value = _homeUiState.value.copy(
            isLoading = true
        )
        viewModelScope.launch {
            try {
                handleCountryListUiMapping()
            } catch (e: java.lang.Exception) {
                _homeUiState.value = _homeUiState.value.copy(
                    message = _homeUiState.value.message.copy(
                        message = e.message,
                        isError = true,
                    ),
                    isLoading = false
                )
            }
        }
    }

    private suspend fun handleCountryListUiMapping() {
        getCountriesListUseCase.execute().collect {
            val countriesList = mutableListOf<HomeUiState.CountryItemUiState>()
            it.forEach { country ->
                countriesList.add(
                    HomeUiState.CountryItemUiState(
                        country = country,
                        onClicked = { onCountryClicked() }
                    )
                )
            }
            _homeUiState.value = _homeUiState.value.copy(
                countries = countriesList,
                isLoading = false
            )
        }
    }

    private fun onCountryClicked() {
        setIsToNavigate(true)
    }

    fun setIsToNavigate(boolean: Boolean) {
        _homeUiState.value = _homeUiState.value.copy(
            isToNavigate = boolean
        )
    }
}