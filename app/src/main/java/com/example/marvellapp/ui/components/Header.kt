package com.example.marvel_app_android.ui.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun Header() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = Modifier
            .fillMaxWidth()

            .padding(10.dp)
    ) {


        Image(
            painter = painterResource(id =  com.example.marvellapp.R.drawable.marvel),
            contentDescription = "marvel",
            contentScale = ContentScale.FillWidth,
        )


        Text(
            text = "Choose your hero",
            style = TextStyle(color = Color.White, fontSize = 40.sp, fontWeight = FontWeight.Bold)
        )
    }
}
