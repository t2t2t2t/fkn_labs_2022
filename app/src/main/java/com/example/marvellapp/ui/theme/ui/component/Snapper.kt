package com.example.marvel_app_android.ui.component



import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.marvel_app_android.data.Hero
import com.example.marvel_app_android.ui.viewModels.MainViewModel
import dev.chrisbanes.snapper.*


@OptIn(ExperimentalSnapperApi::class)
@Composable
fun Snapper(navController: NavHostController, heroes: List<Hero>, model: MainViewModel = viewModel()) {
    val lazyListState = rememberLazyListState()

    val colorState = remember {
        mutableStateOf(Color(0xFFBB1818))
    }

    val layoutInfo: LazyListSnapperLayoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState)
    val indexLazyList = remember {
        mutableStateOf(layoutInfo.currentItem?.index)
    }
    indexLazyList.value = layoutInfo.currentItem?.index


    LaunchedEffect(lazyListState.isScrollInProgress) {

        if (layoutInfo.currentItem?.index != null) {
            val index = layoutInfo.currentItem?.index ?: 0
            var colorIndex=index%7

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
                            HeroCard(
                                name = hero.name,
                                heroPainter = hero.path,
                                index = hero.id,
                                navController = navController,

                                )
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

