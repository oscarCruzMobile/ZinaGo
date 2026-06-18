package com.oscarcruz.zinago.ui.components.menu.menuBottom

sealed interface MenuBottomEvent {
    data class NavigateTo(val index: Int) : MenuBottomEvent
}