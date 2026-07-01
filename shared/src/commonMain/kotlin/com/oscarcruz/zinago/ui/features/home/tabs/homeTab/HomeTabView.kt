package com.oscarcruz.zinago.ui.features.home.tabs.homeTab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oscarcruz.zinago.ui.components.layers.ScreenContainerLayer

@Composable
fun HomeTabView() {
    ScreenContainerLayer(modifier = Modifier.padding(bottom = 80.dp)) {
        Column {
            // Header
            Row(modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.tertiaryContainer)) { }

            Spacer(modifier = Modifier.height(12.dp))

            // Header 2
            Row(modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onSecondary)) { }

            Spacer(modifier = Modifier.height(15.dp))

        }
    }
}

@Composable
fun MiPagerEjemplo() {
    val paginas = listOf("Inicio", "Explorar", "Perfil")
    // Creamos el estado del pager
    val pagerState = rememberPagerState(pageCount = { paginas.size })

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            // Contenido de cada página
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Página: ${paginas[page]}")
            }
        }
    }
}