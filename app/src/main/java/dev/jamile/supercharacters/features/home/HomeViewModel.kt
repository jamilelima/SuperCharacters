package dev.jamile.supercharacters.features.home

import dev.jamile.supercharacters.base.BaseViewModel
import dev.jamile.supercharacters.network.Result
import dev.jamile.supercharacters.repository.CharactersRepository
import dev.jamile.supercharacters.utils.coroutines.DispatchersProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: CharactersRepository,
    private val dispatchersProvider: DispatchersProvider
) : BaseViewModel(dispatchersProvider) {

    private val _homeStateFlow = MutableStateFlow<HomeViewState>(HomeViewState.Loading)
    val homeStateFlow = _homeStateFlow.asStateFlow()

    fun getSuperCharacters() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            onError(exception)
        }

        scope.launch(dispatchersProvider.main + coroutineExceptionHandler) {
            when (val response = repository.getCharacters(10)) {
                is Result.Success -> {
                    _homeStateFlow.emit(
                        HomeViewState.Success(response.data.results)
                    )
                }
                is Result.Failure -> {
                    _homeStateFlow.emit(
                        HomeViewState.NetworkError("Ops! We have a problem here. Try again later!")
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