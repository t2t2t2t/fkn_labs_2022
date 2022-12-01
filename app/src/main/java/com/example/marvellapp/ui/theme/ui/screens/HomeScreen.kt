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
import com.example.marvel_app.ui.theme.ui.screens.ErrorScreen
import com.example.marvel_app_android.ui.component.BackgroundTriangle
import com.example.marvel_app_android.ui.component.Header
import com.example.marvel_app_android.ui.component.Snapper
import com.example.marvellapp.ui.theme.ui.component.getDataForHeroMutableList
import com.example.marvellapp.ui.theme.ui.data.HeroDataList.heroMutableList


@Composable
fun HomeScreen(navController: NavHostController,) {
    heroMutableList = getDataForHeroMutableList()
    if (heroMutableList[0].name == "Error" || heroMutableList.isEmpty()) {
        ErrorScreen()
    } else {
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
            Snapper(navController = navController)
        }
    }
    }
}






