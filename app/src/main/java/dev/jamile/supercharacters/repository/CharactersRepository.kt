package dev.jamile.supercharacters.repository

import dev.jamile.supercharacters.datasource.models.CharactersResponse
import dev.jamile.supercharacters.network.Result

interface CharactersRepository {
    suspend fun getCharacters(limit: Int): Result<CharactersResponse>
}