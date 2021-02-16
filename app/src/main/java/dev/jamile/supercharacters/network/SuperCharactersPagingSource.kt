package dev.jamile.supercharacters.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.jamile.supercharacters.datasource.models.Character
import retrofit2.HttpException
import java.io.IOException

class SuperCharactersPagingSource(private val service: ApiService) : PagingSource<Int, Character>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val position = params.key ?: START_INDEX
        return try {
            val characterList = service.getCharacters(position, LIMIT).body()?.results
            val emptyList = emptyList<Character>()
            val data = characterList ?: emptyList
            LoadResult.Page(
                data = data,
                prevKey = if (position == START_INDEX) null else position - 20,
                nextKey = if (data.isEmpty()) null else position + 20
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }

    companion object {
        const val START_INDEX = 20
        const val LIMIT = 10
    }
}