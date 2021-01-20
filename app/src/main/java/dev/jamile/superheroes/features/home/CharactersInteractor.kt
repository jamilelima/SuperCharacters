package dev.jamile.superheroes.features.home

import dev.jamile.superheroes.network.Resource

interface CharactersInteractor {
    private fun getHeroes(): Resource<Characters>

}