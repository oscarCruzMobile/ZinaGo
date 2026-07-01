package com.oscarcruz.zinago

import androidx.compose.ui.window.ComposeUIViewController
import com.oscarcruz.zinago.di.initKoin
fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) { App() }