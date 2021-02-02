package dev.jamile.superheroes.network

import dev.jamile.superheroes.datasource.models.HeroesResponse
import dev.jamile.superheroes.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("characters/?api_key=${API_KEY}&format=json")
    suspend fun getCharacters(@Query("limit") limit: Int): Response<HeroesResponse>
}
