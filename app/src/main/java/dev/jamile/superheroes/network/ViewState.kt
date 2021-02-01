package dev.jamile.superheroes.network

import dev.jamile.superheroes.datasource.models.Character

sealed class ViewState {
    object Loading : ViewState()
    data class Success(val repositories: List<Character>?) : ViewState()
    data class Error(val errorMessage: String?) : ViewState()
}