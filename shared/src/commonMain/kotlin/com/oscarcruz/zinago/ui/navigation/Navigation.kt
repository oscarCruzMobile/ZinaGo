package com.oscarcruz.zinago.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oscarcruz.zinago.ui.features.home.HomeView
import com.oscarcruz.zinago.ui.features.splash.SplashView
import com.oscarcruz.zinago.ui.features.tour.TourView
import kotlinx.serialization.Serializable

@Serializable object SplashDestination
@Serializable object TourDestination
@Serializable object HomeDestination

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SplashDestination
    ) {
        composable<SplashDestination> {
            SplashView(
                navigateTour = { navController.navigateAndClear(TourDestination) },
                navigateHome = { navController.navigateAndClear(HomeDestination) }
            )
        }

        composable<TourDestination> {
            TourView(navigateHome = { navController.navigateAndClear(HomeDestination) })
        }

        composable<HomeDestination>(
            enterTransition = {
                val duration = 100
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = duration, easing = FastOutSlowInEasing)
                ) + fadeIn(
                    animationSpec = tween(durationMillis = duration, easing = FastOutSlowInEasing)
                )
            }
        ) {
            // HomeView ya contiene el Scaffold + MenuBottom + sub-navegación
            HomeView()
        }
    }
}

inline fun <reified T : Any> NavHostController.navigateAndClear(route: T) {
    navigate(route) {
        currentDestination?.route?.let { popUpTo(it) { inclusive = true } }
        launchSingleTop = true
    }
}