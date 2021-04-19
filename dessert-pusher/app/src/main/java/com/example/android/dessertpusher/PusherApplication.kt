package com.example.android.dessertpusher

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

class PusherApplication : Application() {
    override fun onCreate() {
        Timber.plant(DebugTree())
        super.onCreate()
    }
}
