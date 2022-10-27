package com.example.marvel_app_android.ui.component


import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.marvel_app_android.ui.data.Hero
import com.example.marvel_app_android.ui.viewModels.MainViewModel
import dev.chrisbanes.snapper.*


@OptIn(ExperimentalSnapperApi::class)
@Composable
fun Snapper(heroes: List<Hero>,navController: NavHostController,model: MainViewModel = viewModel()) {
    val lazyListState = rememberLazyListState()
    val layoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState)

    LaunchedEffect(lazyListState.isScrollInProgress) {

            if (layoutInfo.currentItem?.index != null) {
                val index = layoutInfo.currentItem?.index ?: 0
                val offset: Int = layoutInfo.currentItem?.offset ?: -1
                var colorIndex=index

                if (index == heroes.size -2 && offset<0){
                    colorIndex=index+1
                }

                model.setColor(colorIndex)
                model.snapedItem = colorIndex
            }
    }
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center,

        ) {
        LazyRow(
            state = lazyListState,
            flingBehavior = rememberSnapperFlingBehavior(lazyListState = lazyListState,
                snapOffsetForItem = SnapOffsets.Center,),
            contentPadding = PaddingValues( 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {

            itemsIndexed(heroes) {index,  hero ->
                Layout(
                    content = {
                        Box(
                            Modifier.fillMaxSize()
                        ) {
                           HeroCard(hero, heroes.indexOf(hero), layoutInfo, navController)
                        }

                    },
                    measurePolicy = { measurables, constraints ->
                        val placeable = measurables.first().measure(constraints)
                        val maxWidthInPx = maxWidth.roundToPx()
                        val itemWidth = placeable.width
                        val startSpace =
                            if (index == 0) (maxWidthInPx - itemWidth) / 2 else 0
                        val endSpace =
                            if (index == heroes.size-1) (maxWidthInPx - itemWidth) / 2 else 0
                        val width = startSpace + placeable.width + endSpace
                        layout(width, placeable.height) {
                            val x = if (index == 0) startSpace else 0
                            placeable.place(x, 0)
                        }
                    }
                )
            }
        }
    }
}

