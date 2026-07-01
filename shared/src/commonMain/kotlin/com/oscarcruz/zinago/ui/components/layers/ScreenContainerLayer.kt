package com.oscarcruz.zinago.ui.components.layers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScreenContainerLayer(
    modifier: Modifier = Modifier, // Usamos ':' para el tipo y '=' para el valor por defecto
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier // Aquí usamos el parámetro 'modifier' que recibe la función
            .fillMaxSize()
            .padding(horizontal = 15.dp)
    ) {
        content()
    }
}