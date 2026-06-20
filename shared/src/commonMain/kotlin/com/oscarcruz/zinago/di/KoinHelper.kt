package com.oscarcruz.zinago.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

// Cambia la función por un objeto o una clase para asegurar su exposición en Swift
object KoinHelper {
    fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
        startKoin {
            appDeclaration()
            modules(appModule)
        }
    }
}