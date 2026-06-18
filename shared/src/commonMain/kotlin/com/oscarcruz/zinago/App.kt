package com.oscarcruz.zinago

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oscarcruz.zinago.ui.components.layers.BackGroundContentLayer
import com.oscarcruz.zinago.ui.components.layers.ScreenContainerLayer
import com.oscarcruz.zinago.ui.components.menu.menuBottom.MenuBottom
import com.oscarcruz.zinago.ui.theme.AspenTheme
import org.jetbrains.compose.resources.painterResource
import zinago.shared.generated.resources.Res
import zinago.shared.generated.resources.icon_zinago

@Composable
fun App() {
    AspenTheme {
        BackGroundContentLayer {
            // ScreenContainerLayer añade un padding horizontal,
            // ideal para el cuerpo de la app pero no siempre para el menú flotante.
            ScreenContainerLayer {
                // Usamos un Box para superponer los elementos
                Box(modifier = Modifier.fillMaxSize()) {

                    // 1. Contenido principal (centrado arriba)
                    ViewContent()

                    // 2. Menú (anclado abajo)
                    // Usamos alignment para fijarlo al bottom
                    MenuBottom(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 14.dp)

                    )
                }
            }
        }
    }
}

@Composable
fun ViewContent() {
    val greeting = remember { Greeting().greet() }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.icon_zinago), // Usando el recurso convertido
            contentDescription = "Zinago Icon",
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.DarkGray)) {
                    append("Todo lo que amas, ")
                }
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)) {
                    append("al alcance de tu mano.")
                }
            },
            fontSize = 31.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
        )
    }
}