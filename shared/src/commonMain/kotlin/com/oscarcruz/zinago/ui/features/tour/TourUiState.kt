package com.oscarcruz.zinago.ui.features.tour

import zinago.shared.generated.resources.Res
import zinago.shared.generated.resources.ic_hotel
import zinago.shared.generated.resources.ic_location
import zinago.shared.generated.resources.ic_restaurant

data class TourUiState(
    val items: List<TourItem> = listOf(
        TourItem(Res.drawable.ic_hotel, "Hopedaje", "Los mejores hoteles y posadas"),
        TourItem(Res.drawable.ic_restaurant, "Restaurantes", "Gastronomía local y gourmet"),
        TourItem(Res.drawable.ic_location, "Atracciones", "Cultura aventura y más")
    )
)
