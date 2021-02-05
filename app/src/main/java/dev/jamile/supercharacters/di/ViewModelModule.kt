package dev.jamile.superheroes.di

import dev.jamile.superheroes.features.home.HomeViewModel
import dev.jamile.superheroes.utils.coroutines.DispatchersProvider
import dev.jamile.superheroes.utils.coroutines.MainDispatchersProvider
import org.koin.dsl.module

val viewModelModule = module {
    factory<DispatchersProvider> { MainDispatchersProvider }
    factory { HomeViewModel(get(), get()) }
}