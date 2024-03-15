package com.hmj3908.lockscreenex

import android.app.Application
import android.content.Intent
import android.content.IntentFilter
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {
    private lateinit var screenOnReceiver: ScreenOnReceiver

    override fun onCreate() {
        super.onCreate()
        registerScreenOnReceiver()
    }

    private fun registerScreenOnReceiver() {
        screenOnReceiver = ScreenOnReceiver()
        val filter = IntentFilter(Intent.ACTION_SCREEN_ON)
        registerReceiver(screenOnReceiver, filter)
    }

    override fun onTerminate() {
        unregisterReceiver(screenOnReceiver)
        super.onTerminate()
    }
}