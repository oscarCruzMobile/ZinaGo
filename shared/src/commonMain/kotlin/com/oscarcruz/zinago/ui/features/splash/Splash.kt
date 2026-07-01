package com.oscarcruz.zinago.ui.features.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import org.jetbrains.compose.resources.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.oscarcruz.zinago.ui.components.layers.BackGroundContentLayer
import com.oscarcruz.zinago.ui.theme.BgAmarillo
import org.koin.compose.viewmodel.koinViewModel
import zinago.shared.generated.resources.Res
import zinago.shared.generated.resources.ic_splash_bg
import zinago.shared.generated.resources.ic_stroke_app

// ESTA FUNCIÓN ES PARA TU APP (con lógica)

@Composable
fun SplashView(
    navigateTour: () -> Unit,
    navigateHome: () -> Unit,
    viewModel: SplashViewModel = koinViewModel()
) {

    // Escucha el evento de navegación proveniente del ViewModel
    LaunchedEffect(Unit) {
        viewModel.navigationEvent.collect { event ->
            if (event == "navigate_next") {
                navigateTour()
            }
        }
    }

    // Dibujamos el contenido
    SplashContent()
}

// ESTA FUNCIÓN ES PARA EL PREVIEW (sin lógica)
@Preview(
    showSystemUi = true,
    device = "spec:width=1080px,height=2340px,dpi=440,isRound=false,orientation=portrait"
)
@Composable
fun SplashPreview() {
    SplashContent()
}

@Composable
fun SplashContent() {
    BackGroundContentLayer(backgroundColor = BgAmarillo){
    val appendtitle = buildAnnotatedString {
        // Primera parte: "zina"
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onSecondaryContainer)) {
            append("zina")
        }
        // Segunda parte: " Go!"
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme. onSurfaceVariant)) {
            append(" Go!")
        }
    }
    val slogan = buildAnnotatedString {
        // "Tu viaje" - Ligero y base
        withStyle(style = SpanStyle(
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontWeight = FontWeight.Light,
            fontSize = 28.sp
        )) {
            append("Tu viaje ")
        }

        // "comienza" - El puente (énfasis suave)
        withStyle(style = SpanStyle(
            color = MaterialTheme.colorScheme.primary, // Usamos el color primario para resaltar
            fontWeight = FontWeight.Medium,
            fontSize = 28.sp
        )) {
            append("comienza ")
        }

        // "con nosotros." - El cierre (impacto visual)
        withStyle(style = SpanStyle(
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp
        )) {
            append("con nosotros.")
        }
    }
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()) {
        val (img, icon, title, subtitle) = createRefs()
        Image(
            painter = painterResource(Res.drawable.ic_splash_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
                .constrainAs(img) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                ,
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center,
        )
        Image(
            painter = painterResource(Res.drawable.ic_stroke_app),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp) // Define el tamaño antes del constraint
                .constrainAs(icon) {
                    // Centrado horizontal y vertical
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom, margin = 160.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSecondary),
            contentScale = ContentScale.Fit, // Mantiene la relación de aspecto original
            alignment = Alignment.Center
        )

        Text(
            text = appendtitle,
            fontSize = 43.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center, // Esto centra el texto horizontalmente
            modifier = Modifier.fillMaxWidth()
                .constrainAs(title){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(icon.bottom, margin = 40.dp)
                }
        )

        Text(
            text = slogan,
            textAlign = TextAlign.Center, // Esto centra el texto horizontalmente
            modifier = Modifier.fillMaxWidth()
                .constrainAs(subtitle){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 40.dp)
                }
        )

    }


}
}