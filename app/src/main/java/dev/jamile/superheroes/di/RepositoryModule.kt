package dev.jamile.superheroes.di

import dev.jamile.superheroes.repository.CharactersRepository
import dev.jamile.superheroes.repository.CharactersRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<CharactersRepository> { CharactersRepositoryImpl(get()) }
}