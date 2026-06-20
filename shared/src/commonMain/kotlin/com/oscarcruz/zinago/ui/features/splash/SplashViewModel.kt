package com.oscarcruz.zinago.ui.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    // 1. Definimos el Channel. Usamos BufferOverflow.DROP_OLDEST por seguridad,
    // aunque en un Splash raramente tendremos colisiones.
    private val _navigationEvent = Channel<String>(Channel.BUFFERED)

    // 2. Exponemos como Flow para que la UI pueda colectar de forma segura
    val navigationEvent = _navigationEvent.receiveAsFlow()

    init {
        startTimer()
    }

    private fun startTimer() {
        viewModelScope.launch {
            delay(6000) // 7 segundos como definiste
            _navigationEvent.send("navigate_next")
        }
    }
}