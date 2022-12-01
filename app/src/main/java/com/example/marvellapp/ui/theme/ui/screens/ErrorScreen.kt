package com.example.marvel_app.ui.theme.ui.screens

import android.os.Process
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ErrorScreen(){
    Text(
        text = "Нет подключения к интернету, не удалось загрузить данные!",
        modifier = Modifier.padding(
            start = 30.dp,
            top = 40.dp),
        style = TextStyle(
            color = Color.Black,
            fontSize = 35.sp)
    )
    Box(
        modifier = Modifier.fillMaxSize(),
        Alignment.Center
    ) {
        Button(onClick = {
            Process.killProcess(Process.myPid())

        } , modifier = Modifier.height(50.dp).width(100.dp)) {
            Text(
                text = "Выход",
                style = TextStyle(color = Color.White, fontSize = 20.sp)
            )
        }
    }
}