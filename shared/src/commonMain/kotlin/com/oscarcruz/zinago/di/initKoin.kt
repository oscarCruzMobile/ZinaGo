package com.oscarcruz.zinago.di

import org.koin.dsl.KoinAppDeclaration
import org.koin.core.context.startKoin

fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(appModule,imageLoaderModule,dispatchersModule)
    }
}