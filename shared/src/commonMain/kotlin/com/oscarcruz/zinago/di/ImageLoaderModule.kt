package com.oscarcruz.zinago.di

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.request.crossfade
import org.koin.dsl.module

val imageLoaderModule = module {
    single {
        ImageLoader.Builder(get<PlatformContext>())
            .components {
                add(KtorNetworkFetcherFactory())
            }
            .crossfade(true)
            .build()
    }
}