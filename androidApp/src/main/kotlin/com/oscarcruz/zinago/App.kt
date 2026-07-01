package com.oscarcruz.zinago

import android.app.Application
import com.oscarcruz.zinago.di.initKoinAndroid


class ApplicationBase : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoinAndroid(this)
    }
}