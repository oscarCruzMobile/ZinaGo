package com.oscarcruz.zinago.di

import com.oscarcruz.zinago.ui.features.splash.SplashViewModel
import com.oscarcruz.zinago.ui.features.tour.TourViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    // 1. Capa de datos

    // 2. Capa de UI
    viewModelOf(::TourViewModel)
    viewModelOf(::SplashViewModel)
}