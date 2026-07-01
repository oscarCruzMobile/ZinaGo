package com.oscarcruz.zinago.ui.features.home

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oscarcruz.zinago.ui.components.layers.BackGroundContentLayer
import com.oscarcruz.zinago.ui.components.menu.menuBottom.MenuBottom
import com.oscarcruz.zinago.ui.components.menu.menuBottom.MenuBottomViewModel
import com.oscarcruz.zinago.ui.features.home.tabs.homeTab.HomeTabView
import com.oscarcruz.zinago.ui.features.home.tabs.likesTab.LikesTabView
import com.oscarcruz.zinago.ui.features.home.tabs.profileTab.ProfileTabView
import com.oscarcruz.zinago.ui.features.home.tabs.StoreTab.StoreTabView
import com.oscarcruz.zinago.ui.navigation.navigateAndClear


@Composable
fun HomeView(
    menuViewModel: MenuBottomViewModel = viewModel { MenuBottomViewModel() }
) {
    // NavController interno — solo para las tabs del menú
    val tabNavController = rememberNavController()

    LaunchedEffect(Unit) {
        menuViewModel.events.collect { event ->
            when (event) {
                is com.oscarcruz.zinago.ui.components.menu.menuBottom.MenuBottomEvent.NavigateTo -> {
                    val destination = when (event.index) {
                        0 -> HomeTabDestination
                        1 -> LikesTabDestination
                        2 -> StoreTabDestination
                        3 -> ProfileTabDestination
                        else -> HomeTabDestination
                    }

                    // Usando tu función de extensión personalizada
                    tabNavController.navigateAndClear(destination)
                }
            }
        }
    }

    BackGroundContentLayer(
        backgroundColor = MaterialTheme.colorScheme.background
    ) {

    Box(modifier = Modifier.fillMaxSize()) {

        // ── Contenido de las tabs ─────────────────────────────────────────
        NavHost(
            navController = tabNavController,
            startDestination = HomeTabDestination,
            enterTransition = { EnterTransition.None },
            exitTransition  = { ExitTransition.None },
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp) // deja espacio al MenuBottom flotante
        ) {
            composable<HomeTabDestination>    { HomeTabView() }
            composable<LikesTabDestination>   { LikesTabView() }
            composable<StoreTabDestination>   { StoreTabView() }
            composable<ProfileTabDestination> { ProfileTabView() }
        }

        // ── MenuBottom flotante sobre el contenido ────────────────────────
        MenuBottom(
            viewModel = menuViewModel,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                                      // 1° insets del sistema
                .padding( vertical = 12.dp)  // 2° margen visual
        )
    } }
}