package dev.jamile.supercharacters.di

import dev.jamile.supercharacters.network.ApiService
import dev.jamile.supercharacters.network.RequestInterceptor
import dev.jamile.supercharacters.network.SuperCharactersPagingSource
import dev.jamile.supercharacters.utils.BASE_URL
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
    factory { SuperCharactersPagingSource(get()) }
}