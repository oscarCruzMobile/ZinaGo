package com.oscarcruz.zinago.di

import com.oscarcruz.zinago.ui.features.splash.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Registramos el ViewModel
    viewModel { SplashViewModel() }
}