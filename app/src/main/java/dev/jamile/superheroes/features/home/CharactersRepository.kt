package dev.jamile.superheroes.features.home

import dev.jamile.superheroes.datasource.models.HeroesResponse
import dev.jamile.superheroes.network.ApiResponse

interface CharactersRepository {
    suspend fun getHeroes(limit: Int): ApiResponse<HeroesResponse?>
}