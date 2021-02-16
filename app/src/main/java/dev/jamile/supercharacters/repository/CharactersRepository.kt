package dev.jamile.supercharacters.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.jamile.supercharacters.datasource.models.Character
import dev.jamile.supercharacters.network.SuperCharactersPagingSource
import kotlinx.coroutines.flow.Flow

class CharactersRepository(private val charactersPagingSource: SuperCharactersPagingSource) {
    fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { charactersPagingSource }
        ).flow
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}
