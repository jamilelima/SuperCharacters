package dev.jamile.supercharacters.network

import dev.jamile.supercharacters.BuildConfig
import dev.jamile.supercharacters.datasource.models.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("characters")
    suspend fun getCharacters(@Query("limit") limit: Int): Response<CharactersResponse>
}
