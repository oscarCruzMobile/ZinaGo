package com.oscarcruz.zinago.ui.features.tour

sealed class TourUiAction {
    data object OnItemClick : TourUiAction()
}