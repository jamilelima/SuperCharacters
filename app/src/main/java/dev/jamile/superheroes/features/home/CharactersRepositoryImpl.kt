package dev.jamile.superheroes.features.home

import android.util.Log
import dev.jamile.superheroes.datasource.models.HeroesResponse
import dev.jamile.superheroes.network.ApiResponse
import dev.jamile.superheroes.network.ApiService

class CharactersRepositoryImpl(private val apiService: ApiService) : CharactersRepository {
    override suspend fun getHeroes(limit: Int): ApiResponse<HeroesResponse?> {
        val response = apiService.getCharacters(limit)
        if (response.isSuccessful && response.body() != null) {
            Log.d("response:", "getHeroes: ${response.body()}")
            return ApiResponse.Success(response.body())
        }
        return ApiResponse.Failure(Throwable("Error ${response.errorBody()} ${response.message()}"))
    }
}