package com.oscarcruz.zinago.ui.features.tour

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class TourViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TourUiState())
    val uiState: StateFlow<TourUiState> = _uiState.asStateFlow()

    // 1. Cambia el tipo de Channel a TourUiEvent
    private val _events = Channel<TourUiEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

   fun onAction(action: TourUiAction) {
        when (action) {
            is TourUiAction.OnItemClick -> navigateNext()
        }
    }

    fun navigateNext() {
        viewModelScope.launch {
            // 2. Cierra el paréntesis que faltaba
            _events.send(TourUiEvent.NavigationNext(NavigationDest.ToHome))
        }
    }
}