package dev.jamile.superheroes.features.home

import dev.jamile.superheroes.datasource.models.HeroesResponse
import dev.jamile.superheroes.network.Result

interface CharactersRepository {
    suspend fun getHeroes(limit: Int): Result<HeroesResponse>
}