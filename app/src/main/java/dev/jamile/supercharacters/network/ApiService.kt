package dev.jamile.supercharacters.network

import dev.jamile.supercharacters.datasource.models.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<CharactersResponse>
}
