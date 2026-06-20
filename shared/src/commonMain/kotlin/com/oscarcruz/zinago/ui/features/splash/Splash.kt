package com.oscarcruz.zinago.ui.features.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import androidx.compose.ui.tooling.preview.Preview
import zinago.shared.generated.resources.Res
import zinago.shared.generated.resources.zina_bg

// ESTA FUNCIÓN ES PARA TU APP (con lógica)
@Composable
fun SplashView(navigateTour: () -> Unit, navigateHome: () -> Unit) {
    SplashContent()
}

// ESTA FUNCIÓN ES PARA EL PREVIEW (sin lógica)
@Preview
@Composable
fun SplashPreview() {
    SplashContent()
}

@Composable
fun SplashContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3DBFB8))
    ) {
        Image(
            painter = painterResource(Res.drawable.zina_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
    }
}