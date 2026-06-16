package com.oscarcruz.zinago

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import zinago.shared.generated.resources.Res
import zinago.shared.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        val greeting = remember { Greeting().greet() }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
                Image(painterResource(Res.drawable.compose_multiplatform), null)
                Text("It´s a new project" ,
                    textAlign = TextAlign.Center,
                        color = Color.DarkGray,              // Cambiar color
                    fontSize = 33.sp,               // Cambiar tamaño (usa .sp para texto)
                    fontWeight = FontWeight.SemiBold)

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.DarkGray)) {
                        append("Let´s start ")
                    }
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                        append("$greeting") // He quitado el espacio extra que tenías
                    }
                },
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,       // <--- Aquí es donde debe ir
                modifier = Modifier.fillMaxWidth()  // <--- Necesario para que el centrado surta efecto
            )

            }

    }
}