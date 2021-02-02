package dev.jamile.superheroes.features.home

import android.util.Log
import dev.jamile.superheroes.base.BaseViewModel
import dev.jamile.superheroes.utils.coroutines.DispatchersProvider

class HomeViewModel(
    private val repository: CharactersRepository,
    dispatchersProvider: DispatchersProvider
) : BaseViewModel(dispatchersProvider) {

    fun teste() {
        launchMain {
            val response = repository.getHeroes(2)
            Log.d("TAG", "teste: ${response}")
        }
    }
}