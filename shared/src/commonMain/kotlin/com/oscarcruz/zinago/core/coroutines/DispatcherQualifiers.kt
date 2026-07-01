package com.oscarcruz.zinago.core.coroutines

import org.koin.core.qualifier.named

val IoDispatcher = named("IoDispatcher")
val DefaultDispatcher = named("DefaultDispatcher")
val MainDispatcher = named("MainDispatcher")