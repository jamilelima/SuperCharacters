package dev.jamile.superheroes.network

import dev.jamile.superheroes.utils.API_KEY
import retrofit2.http.GET

interface ApiService {
    @GET("/characters/?api_key=${API_KEY}&format=json")
    suspend fun getCharacters(): Unit
}
