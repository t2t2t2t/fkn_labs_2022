package com.example.marvel_app_android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.marvel_app_android.ui.component.BackgroundTriangle
import com.example.marvel_app_android.ui.component.Header
import com.example.marvel_app_android.ui.theme.ui.screens.ErrorScreen
import com.example.marvel_app_android.ui.component.Snapper
import com.example.marvel_app_android.ui.viewModels.MainViewModel
import androidx.compose.runtime.*


@Composable
fun HomeScreen(navController: NavHostController,     mainViewModel: MainViewModel = hiltViewModel() ) {


    val heroesState by mainViewModel.heroes.collectAsState()

    val color = remember {
        mutableStateOf(Color.Gray)
    }
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
                .padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Header()
            if (heroesState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(50.dp)
                )

            }
            if (heroesState.error != null) {
                ErrorScreen()
            }
            Snapper(navController = navController,heroes = heroesState.data,)
        }
    }

}

