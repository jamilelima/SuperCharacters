package dev.jamile.supercharacters

import android.app.Application
import android.content.Context
import dev.jamile.supercharacters.di.networkModule
import dev.jamile.supercharacters.di.repositoryModule
import dev.jamile.supercharacters.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SuperCharactersApp : Application() {

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
                    viewModelModule,
                    repositoryModule
                )
            )
        }
    }
}
