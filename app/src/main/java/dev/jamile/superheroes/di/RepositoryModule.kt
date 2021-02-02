package dev.jamile.superheroes.di

import dev.jamile.superheroes.features.home.CharactersRepository
import dev.jamile.superheroes.features.home.CharactersRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<CharactersRepository> { CharactersRepositoryImpl(get()) }
}