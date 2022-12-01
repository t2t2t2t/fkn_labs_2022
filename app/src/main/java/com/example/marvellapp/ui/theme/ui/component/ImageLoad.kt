package com.example.marvel_app_android.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

import coil.request.ImageRequest


@Composable
fun ImageLoad(link: String) {


    SubcomposeAsyncImage(
        model = ImageRequest
            .Builder(LocalContext.current)
            .data(link)
            .build(),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    ) {
        if (painter.state is AsyncImagePainter.State.Loading || painter.state is AsyncImagePainter.State.Error) {
            CircularProgressIndicator(
                modifier =
                Modifier
                    .size(10.dp)
                    .align(Alignment.Center)
            )
        } else {
            SubcomposeAsyncImageContent()
        }
    }
}