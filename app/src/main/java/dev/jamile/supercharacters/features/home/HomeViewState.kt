package dev.jamile.supercharacters.features.home

import dev.jamile.supercharacters.datasource.models.Character

sealed class HomeViewState {
    data class NetworkError(val message: String?) : HomeViewState()
    object Loading : HomeViewState()
    data class Success(val data: List<Character>) : HomeViewState()
}