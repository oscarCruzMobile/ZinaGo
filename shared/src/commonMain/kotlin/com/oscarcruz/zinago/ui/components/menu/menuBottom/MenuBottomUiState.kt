package com.oscarcruz.zinago.ui.components.menu.menuBottom

import org.jetbrains.compose.resources.DrawableResource
import zinago.shared.generated.resources.Res
import zinago.shared.generated.resources.ic_menu_home
import zinago.shared.generated.resources.ic_menu_like
import zinago.shared.generated.resources.ic_menu_store
import zinago.shared.generated.resources.ic_menu_user

enum class MenuTab(val contentDescription: String) {
    HOME("Home"),
    LIKES("Likes"),
    STORE("Store"),
    PROFILE("Profile");

    val iconRes: DrawableResource
        get() = when (this) {
            HOME    -> Res.drawable.ic_menu_home
            LIKES   -> Res.drawable.ic_menu_like
            STORE   -> Res.drawable.ic_menu_store
            PROFILE -> Res.drawable.ic_menu_user
        }
}

data class MenuBottomUiState(
    val selectedIndex: Int = 0,
    val tabs: List<MenuTab> = MenuTab.entries
)