package dev.jamile.superheroes.features.home

import dev.jamile.superheroes.datasource.models.HeroesResponse
import dev.jamile.superheroes.network.Result
import dev.jamile.superheroes.network.ApiService

class CharactersRepositoryImpl(private val apiService: ApiService) : CharactersRepository {
    override suspend fun getHeroes(limit: Int): Result<HeroesResponse> {
        val response = apiService.getCharacters(limit)
        return if (response.isSuccessful) {
            Result.Success(response.body()!!)
        } else {
            Result.Failure(Throwable("Error ${response.errorBody()} ${response.message()}"))
        }
    }
}