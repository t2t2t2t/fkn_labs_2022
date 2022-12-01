package com.example.marvellapp.ui.theme.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marvel_app.ui.theme.ui.data.HeroData
import com.example.marvel_app.ui.theme.ui.model.Results
import com.example.marvel_app.ui.theme.ui.network.RetrofitInstance
import com.example.marvel_app_android.ui.viewModels.MainViewModel
import java.net.UnknownHostException


@Composable
fun getDataForHeroMutableList(model: MainViewModel = viewModel()) : MutableList<HeroData> {
    val api = RetrofitInstance.getMarvelApi()
    val list : List<Results>

    val mutableList : MutableList<HeroData> = mutableListOf()

    try {
        list = api.getCharacters().execute().body()?.data?.results!!
        for (it in list) {
            mutableList.add(
                HeroData(
                    id = it.id!!,
                    name = it.name!!,
                    painter = it.thumbnail?.path + "/portrait_incredible.jpg",
                    color = model.colors.random()
                )
            )
        }
    } catch (e: UnknownHostException) {
        mutableList.add(
            HeroData(
                id = "none",
                name = "Error",
                painter = "none",
                color = Color.Gray
            )
        )
    }
    return mutableList

}
