package com.vanced.faq

import android.app.Application
import com.vanced.faq.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                viewModelModule,
                repositoryModule,
                serviceModule,
                mapperModule,
                markwonModule
            )
        }
    }

}