package com.oscarcruz.zinago.ui.components.menu.menuBottom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MenuBottomViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MenuBottomUiState())
    val uiState: StateFlow<MenuBottomUiState> = _uiState.asStateFlow()

    private val _events = Channel<MenuBottomEvent>(Channel.BUFFERED)
    val events: Flow<MenuBottomEvent> = _events.receiveAsFlow()

    fun onAction(action: MenuBottomAction) {
        when (action) {
            is MenuBottomAction.SelectItem -> selectItem(action.index)
        }
    }

    private fun selectItem(index: Int) {
        if (_uiState.value.selectedIndex == index) return
        _uiState.update { it.copy(selectedIndex = index) }
        viewModelScope.launch {
            _events.send(MenuBottomEvent.NavigateTo(index))
        }
    }
}