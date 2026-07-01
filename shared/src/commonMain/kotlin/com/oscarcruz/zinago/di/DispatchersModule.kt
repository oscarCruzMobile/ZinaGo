package com.oscarcruz.zinago.di

import com.oscarcruz.zinago.core.coroutines.DefaultDispatcher
import com.oscarcruz.zinago.core.coroutines.IoDispatcher
import com.oscarcruz.zinago.core.coroutines.MainDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module

val dispatchersModule = module {
    single(IoDispatcher) { Dispatchers.IO }
    single(DefaultDispatcher) { Dispatchers.Default }
    single(MainDispatcher) { Dispatchers.Main }
}