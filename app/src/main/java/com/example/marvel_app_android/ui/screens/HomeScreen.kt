package com.example.marvel_app_android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.marvel_app_android.ui.component.BackgroundTriangle
import com.example.marvel_app_android.ui.component.Header
import com.example.marvel_app_android.ui.component.Snapper
import com.example.marvel_app_android.ui.data.HeroesData


@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxSize()
    )
    {
        BackgroundTriangle()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(1.dp)
        ) {
            Header()
            Snapper(HeroesData.heros, navController = navController)
        }
    }
}






