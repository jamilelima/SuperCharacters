package dev.jamile.supercharacters.repository

import dev.jamile.supercharacters.datasource.models.CharactersResponse
import dev.jamile.supercharacters.network.Result
import dev.jamile.supercharacters.network.ApiService

class CharactersRepositoryImpl(private val apiService: ApiService) : CharactersRepository {
    override suspend fun getCharacters(limit: Int): Result<CharactersResponse> {
        val response = apiService.getCharacters(limit)
        return if (response.isSuccessful) {
            Result.Success(response.body()!!)
        } else {
            Result.Failure(Throwable("Error ${response.errorBody()} ${response.message()}"))
        }
    }
}