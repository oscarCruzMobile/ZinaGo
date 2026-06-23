package com.oscarcruz.zinago.ui.features.tour

sealed class TourUiEvent {
    data class NavigationNext (val destination: NavigationDest) : TourUiEvent()
}

sealed class NavigationDest {
    data object ToHome : NavigationDest()

}
