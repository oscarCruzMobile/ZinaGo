package com.oscarcruz.zinago.ui.components.media

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import coil3.compose.AsyncImagePainter
import kotlinx.coroutines.flow.StateFlow

@Composable
internal fun StateFlow<AsyncImagePainter.State>.collectAsStateInternal(): State<AsyncImagePainter.State> =
    collectAsState()