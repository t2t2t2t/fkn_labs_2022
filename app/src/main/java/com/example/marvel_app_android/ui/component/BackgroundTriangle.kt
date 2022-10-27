package com.example.marvel_app_android.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marvel_app_android.ui.viewModels.MainViewModel

@Composable
fun BackgroundTriangle(model: MainViewModel = viewModel()) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val trianglePath = Path().apply {
            val height = size.height
            val width = size.width
            moveTo(width, height / 2)
            lineTo(0f, height)
            lineTo(width, height)
        }
        drawPath(trianglePath, color = model.backgroundColor)
    }
}
