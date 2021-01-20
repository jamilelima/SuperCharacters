package dev.jamile.superheroes

import android.app.Application
import android.content.Context
import dev.jamile.superheroes.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SuperHeroesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupApp(baseContext)
    }

    private fun setupApp(ctx: Context) {
        startKoin {
            androidContext(ctx)
            modules(
                listOf(
                    networkModule,
                )
            )
        }
    }
}
