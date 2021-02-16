package dev.jamile.supercharacters.network

import dev.jamile.supercharacters.BuildConfig
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
            val request = chain.request()

            val newUrl = request.url.newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .addQueryParameter("format", "json")
                .build()

            val newRequest = request.newBuilder().url(newUrl).build()

            return@addInterceptor chain.proceed(newRequest)
        }
        return okHttp
    }
}