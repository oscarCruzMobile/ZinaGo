package com.oscarcruz.zinago.ui.features.tour

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.oscarcruz.zinago.ui.components.layers.BackGroundContentLayer
import com.oscarcruz.zinago.ui.theme.BgTurquesa
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import zinago.shared.generated.resources.Res
import zinago.shared.generated.resources.ic_tour_header
@Composable
fun TourView(navigateHome: () -> Unit,
             viewModel: TourViewModel = koinViewModel()) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.events.collectLatest { event ->
            when (event) {
                is TourUiEvent.NavigationNext -> {
                    if (event.destination == NavigationDest.ToHome) {
                        navigateHome()
                    }
                }
            }
        }
    }

    TourContent(
        uiState = uiState,
        onAction = viewModel::onAction)
}

@Composable
fun TourContent(uiState: TourUiState,  onAction: (TourUiAction) -> Unit) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val isSmallScreen = maxHeight < 600.dp
    BackGroundContentLayer(backgroundColor = MaterialTheme.colorScheme.background){
        ConstraintLayout(modifier  = Modifier
            .fillMaxSize()
        ) {
            val (imgHeader, title, card, button) = createRefs()

            Image(
                painter = painterResource(Res.drawable.ic_tour_header),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(imgHeader){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        if (isSmallScreen)   height = Dimension.value(160.dp)

                    },
                contentScale = ContentScale.Crop, // 'Crop' asegura que la imagen llene el espacio sin deformarse
                alignment = Alignment.TopCenter
            )

            Text(
                modifier = Modifier
                    .constrainAs(title) {
                        bottom.linkTo(imgHeader.bottom, margin = if (isSmallScreen) 8.dp else 26.dp  )
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
                    .padding(horizontal = 15.dp),
                text = "Descubre tu próxima aventura",
                fontSize = if (isSmallScreen) 24.sp else 35.sp,
                lineHeight = if (isSmallScreen) 28.sp else 38.sp,
                color = MaterialTheme.colorScheme.background,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            )

            ItemsContainerCard(
                _modifier = Modifier
                    .constrainAs(card) {
                        top.linkTo(imgHeader.bottom )
                        bottom.linkTo(button.top )
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                items = uiState.items
            )
            Button(
                onClick = { onAction(TourUiAction.OnItemClick) },
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = BgTurquesa,
                    contentColor = MaterialTheme.colorScheme.background // Color del texto/icono
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp) // Altura estándar para mejor área de toque
                    .constrainAs(button) {
                        bottom.linkTo(parent.bottom, 24.dp) // Controlamos el espacio desde aquí
                        start.linkTo(parent.start, 16.dp)   // Margen lateral
                        end.linkTo(parent.end, 16.dp)
                        width = Dimension.fillToConstraints
                    }
            ) {
                Text(
                    text = "Comenzar",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
    }
}

@Composable
fun ItemsContainerCard(_modifier : Modifier, items: List<TourItem>) {
    Card(
        modifier = _modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            // Mantenemos el color pero sin alfa o ajustándolo si es necesario
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        // 1. ELIMINAR GROSOR: Elevación a 0 para que sea plana y no tenga sombra gris
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        // Si el borde gris persiste, asegúrate de que no haya un 'border' definido en el constructor
    ) {
        // 2. AJUSTE DE ESPACIO: Añadir un padding vertical al contenedor de los items

            items.forEachIndexed { index, tourItem ->
                Item(icon = tourItem.icon, title = tourItem.title, subTitle = tourItem.subTitle)

                if (index < items.size - 1) {
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                        thickness = 2.dp,
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                    )
                }
            }
        }

}

@Composable
fun Item(icon: DrawableResource, title: String, subTitle: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(0.30f),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(icon),
                contentDescription = title,
                modifier = Modifier.size(62.dp)
            )
        }
        Column(modifier = Modifier.weight(0.70f), horizontalAlignment = Alignment.Start) {
            Text(modifier = Modifier
                .padding(end = 8.dp),
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary)
            Text(modifier = Modifier
                .padding(end = 8.dp),
                text = subTitle,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTourContent() {
    // Puedes crear un estado de prueba aquí
    val mockItems = listOf(
        TourItem(icon = Res.drawable.ic_tour_header, title = "Explora", subTitle = "Descubre lugares increíbles"),
        TourItem(icon = Res.drawable.ic_tour_header, title = "Conecta", subTitle = "Comparte con otros viajeros")
    )
    val mockState = TourUiState(items = mockItems)

    MaterialTheme {
        TourContent(uiState = mockState, onAction = {})
    }
}