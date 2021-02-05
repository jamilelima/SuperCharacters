package dev.jamile.superheroes.features.home

import dev.jamile.superheroes.datasource.models.Character

sealed class HomeViewState {
    data class NetworkError(val message: String?) : HomeViewState()
    object Loading : HomeViewState()
    data class Success(val data: List<Character>) : HomeViewState()
}