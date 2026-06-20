package com.oscarcruz.zinago

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.oscarcruz.zinago.ui.components.layers.BackGroundContentLayer
import com.oscarcruz.zinago.ui.navigation.NavigationWrapper
import com.oscarcruz.zinago.ui.theme.AspenTheme
import com.oscarcruz.zinago.ui.theme.BgAmarillo
import com.oscarcruz.zinago.ui.theme.BgTurquesa


@Composable
fun App() {
    AspenTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavigationWrapper()
        }
    }
}
