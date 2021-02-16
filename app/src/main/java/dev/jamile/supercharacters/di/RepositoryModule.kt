package dev.jamile.supercharacters.di

import dev.jamile.supercharacters.repository.CharactersRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { CharactersRepository(get()) }
}
