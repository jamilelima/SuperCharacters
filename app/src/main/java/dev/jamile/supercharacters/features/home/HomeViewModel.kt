package dev.jamile.supercharacters.features.home

import androidx.paging.PagingData
import androidx.paging.cachedIn
import dev.jamile.supercharacters.base.BaseViewModel
import dev.jamile.supercharacters.datasource.models.Character
import dev.jamile.supercharacters.repository.CharactersRepository
import dev.jamile.supercharacters.utils.coroutines.DispatchersProvider
import kotlinx.coroutines.flow.Flow

class HomeViewModel(
    private val repository: CharactersRepository,
    dispatchersProvider: DispatchersProvider
) : BaseViewModel(dispatchersProvider) {

    fun getAllCharacters(): Flow<PagingData<Character>> {
        return repository.getCharacters().cachedIn(scope)
    }
}

