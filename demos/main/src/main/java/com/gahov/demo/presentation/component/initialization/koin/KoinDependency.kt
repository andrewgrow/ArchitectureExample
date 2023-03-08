package com.gahov.demo.presentation.component.initialization.koin

import android.content.Context
import com.gahov.architecture.BuildConfig
import com.gahov.demo.presentation.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KoinDependency(private val context: Context) {
    init {
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            androidContext(context)
            if (BuildConfig.DEBUG) {
                androidLogger(Level.ERROR)
            }
            modules(appModule)
        }
    }
}