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
import com.example.marvel_app_android.ui.data.Hero
import com.example.marvel_app_android.ui.data.HeroesData
import com.example.marvel_app_android.ui.navigation.Destination
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.LazyListSnapperLayoutInfo


@OptIn(ExperimentalSnapperApi::class)
@Composable
fun HeroCard(
    hero: Hero,
    index: Int,
    layoutInfo: LazyListSnapperLayoutInfo,
    navController: NavHostController
) {

    val offset: Int = layoutInfo.currentItem?.offset ?: -1

    val size: Int = HeroesData.heros.size - 1

    val modifier: Modifier =
        if (index == layoutInfo.currentItem?.index || index == size && offset < 0) Modifier
            .size(
                width = 300.dp,
                height = 500.dp
            )
        else Modifier
            .size(width = 200.dp, height = 400.dp)


    Box(
        modifier =
        modifier
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(10)
            )
            .clip(RoundedCornerShape(10))
            .clickable { navController.navigate(route = Destination.Hero.passID(index)) },


        contentAlignment = Alignment.BottomCenter,
        )
    {
        ImageLoad(link = hero.image)

        Box(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = hero.name,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }


}
