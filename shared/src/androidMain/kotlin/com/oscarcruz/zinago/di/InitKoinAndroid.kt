package com.oscarcruz.zinago.di


import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

fun initKoinAndroid(context: Context) {
    initKoin {
        androidLogger(Level.DEBUG)
        androidContext(context)
    }
}