package dev.jamile.supercharacters.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.jamile.supercharacters.datasource.models.Character
import retrofit2.HttpException
import java.io.IOException

class SuperHeroesPagingSource(private val service: ApiService, private val query: String) : PagingSource<Int, Character>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val position = params.key ?: START_INDEX
        return try {
            val heroesList = service.getCharacters(position).body()?.results
            val emptyList = emptyList<Character>()
            val data = heroesList ?: emptyList
            LoadResult.Page(
                data = data,
                prevKey = if (position == START_INDEX) null else position - 1,
                nextKey = if (data.isEmpty()) null else position + 1
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
        const val START_INDEX = 1
    }
}