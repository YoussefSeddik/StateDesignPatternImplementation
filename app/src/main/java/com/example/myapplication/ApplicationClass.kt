package com.example.myapplication

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class ApplicationClass : MultiDexApplication() {


    companion object {
        // This flag should be set to true to enable VectorDrawable support for API < 21
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationClass)
            androidLogger()
                modules(listOf(appModule))
        }
        MultiDex.install(this)
    }
}