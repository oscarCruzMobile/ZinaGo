package com.oscarcruz.zinago

import androidx.compose.runtime.*
import com.oscarcruz.zinago.ui.components.layers.BackGroundContentLayer
import com.oscarcruz.zinago.ui.components.layers.ScreenContainerLayer
import com.oscarcruz.zinago.ui.navigation.NavigationWrapper
import com.oscarcruz.zinago.ui.theme.AspenTheme


@Composable
fun App() {
    AspenTheme {
        BackGroundContentLayer {
            // ScreenContainerLayer añade un padding horizontal,
            // ideal para el cuerpo de la app pero no siempre para el menú flotante.

                NavigationWrapper()


        }
    }
}

