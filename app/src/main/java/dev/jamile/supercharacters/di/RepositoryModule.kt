package dev.jamile.supercharacters.di

import dev.jamile.supercharacters.repository.CharactersRepository
import dev.jamile.supercharacters.repository.CharactersRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<CharactersRepository> { CharactersRepositoryImpl(get()) }
}