package dev.jamile.supercharacters.di

import dev.jamile.supercharacters.features.home.HomeViewModel
import dev.jamile.supercharacters.utils.coroutines.DispatchersProvider
import dev.jamile.supercharacters.utils.coroutines.MainDispatchersProvider
import org.koin.dsl.module

val viewModelModule = module {
    factory<DispatchersProvider> { MainDispatchersProvider }
    factory { HomeViewModel(get(), get()) }
}