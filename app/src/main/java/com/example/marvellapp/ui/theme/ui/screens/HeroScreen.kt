package com.example.marvel_app_android.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.marvel_app_android.ui.component.ImageLoad
import com.example.marvel_app_android.ui.theme.ui.screens.ErrorScreen
import com.example.marvel_app_android.ui.viewModels.MainViewModel


@Composable
fun HeroScreen(navController: NavHostController,index:Int,mainViewModel: MainViewModel = hiltViewModel()) {

    mainViewModel.getHero(index!!)
    val hero = mainViewModel.hero.collectAsState().value
    if (hero.error!= null) {
        ErrorScreen()
    }

    Box(
        modifier = Modifier
            .fillMaxSize())
    {

        ImageLoad (link = hero.data.path)

        Box( modifier = Modifier
            .clickable { navController.popBackStack() }
            .padding(10.dp))
        {
            Icon(Icons.Rounded.ArrowBack,
                contentDescription = "",
                tint = Color.DarkGray,
                modifier = Modifier.size(50.dp)) }
        Box(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        ) {
            Column() {
                Text(
                    text = hero.data.name,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = hero.data.description,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,

                        )
                )
            }
        }
    }
}