package dev.jamile.superheroes.di

import dev.jamile.superheroes.network.ApiService
import dev.jamile.superheroes.network.RequestInterceptor
import dev.jamile.superheroes.utils.BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(RequestInterceptor.setupOkHttp().build())
            .build()

    }
    single { get<Retrofit>().create(ApiService::class.java) }
}