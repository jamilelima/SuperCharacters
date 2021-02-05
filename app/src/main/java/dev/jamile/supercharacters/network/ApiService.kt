package dev.jamile.supercharacters.network

import dev.jamile.supercharacters.datasource.models.CharactersResponse
import dev.jamile.supercharacters.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("characters/?api_key=${API_KEY}&format=json")
    suspend fun getCharacters(@Query("limit") limit: Int): Response<CharactersResponse>
}
