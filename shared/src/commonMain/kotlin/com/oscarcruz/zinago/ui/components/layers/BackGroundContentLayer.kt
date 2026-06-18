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
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    useSafePadding: Boolean = true,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        // Aplicamos padding solo si se requiere
        val contentModifier = if (useSafePadding) Modifier.safeDrawingPadding() else Modifier

        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(contentModifier)
        ) {
            content()
        }
    }
}