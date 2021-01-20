package dev.jamile.superheroes.features.home

import dev.jamile.superheroes.base.BaseViewModel
import dev.jamile.superheroes.utils.coroutines.DispatchersProvider

class HomeViewModel(
    private val repository: CharactersInteractor,
    dispatchersProvider: DispatchersProvider
) : BaseViewModel(dispatchersProvider) {

    private fun teste() {
        repository
    }
}