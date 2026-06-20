package com.oscarcruz.zinago.ui.features.tour

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.oscarcruz.zinago.Greeting
import org.jetbrains.compose.resources.painterResource
import zinago.shared.generated.resources.Res
import zinago.shared.generated.resources.icon_zinago


@Composable
fun TourView(onFinishTour: () -> Unit) {
    TourContent()
}
@Composable
fun TourContent() {
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