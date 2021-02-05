package dev.jamile.superheroes.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object RequestInterceptor {

    fun logger(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC
        return logger
    }

    fun setupOkHttp(): OkHttpClient.Builder {
        val okHttp = OkHttpClient.Builder()
        okHttp.addInterceptor(logger())
        okHttp.addInterceptor { chain ->
            return@addInterceptor chain.proceed(chain.request())
        }
        return okHttp
    }
}