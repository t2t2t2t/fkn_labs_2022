package com.example.marvel_app_android.ui.component


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.marvel_app_android.ui.navigation.Destination


@Composable
fun HeroCard(
    name: String,
    heroPainter: String,
    navController: NavHostController,
    index: Int,

    ) {
    Box(
        modifier =
        Modifier
            .size(
                width = 300.dp,
                height = 500.dp
            )
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(10)
            )
            .clip(RoundedCornerShape(10))
            .clickable { navController.navigate(route = Destination.Hero.passID(index)) },


        contentAlignment = Alignment.BottomCenter,
    )
    {
        ImageLoad(link = heroPainter)

        Box(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = name,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }


}
