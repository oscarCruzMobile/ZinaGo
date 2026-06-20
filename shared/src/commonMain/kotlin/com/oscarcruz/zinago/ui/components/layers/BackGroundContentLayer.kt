package com.oscarcruz.zinago.ui.components.layers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BackGroundContentLayer(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    content: @Composable () -> Unit
) {
    // 1. Capa de Fondo (Edge-to-Edge puro)
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor) // Llena hasta el borde (notch/gestos)
    ) {
        // 2. Capa de Seguridad (Solo empuja el contenido)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding() // Ajuste automático para iOS y Android
        ) {
            content()
        }
    }
}