package com.oscarcruz.zinago.ui.components.menu.menuBottom

sealed interface MenuBottomAction {
    data class SelectItem(val index: Int) : MenuBottomAction
}