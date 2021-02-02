package dev.jamile.superheroes.features.home

import dev.jamile.superheroes.base.BaseViewModel
import dev.jamile.superheroes.network.Result
import dev.jamile.superheroes.utils.coroutines.DispatchersProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: CharactersRepository,
    private val dispatchersProvider: DispatchersProvider
) : BaseViewModel(dispatchersProvider) {

    private val _homeStateFlow = MutableStateFlow<HomeViewState>(HomeViewState.Loading)
    private val homeStateFlow = _homeStateFlow.asStateFlow()

    fun getSuperHeroes() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            onError(exception)
        }

        scope.launch(dispatchersProvider.main + coroutineExceptionHandler) {
            when (val response = repository.getHeroes(2)) {
                is Result.Success -> {
                    _homeStateFlow.emit(
                        HomeViewState.Success(response.data.results)
                    )
                }
                is Result.Failure -> {
                    _homeStateFlow.emit(
                        HomeViewState.NetworkError("")
                    )
                }
            }
        }
    }

    private fun onError(throwable: Throwable) {
        _homeStateFlow.value = HomeViewState.NetworkError(throwable.localizedMessage)
        // Setup error here
    }

}