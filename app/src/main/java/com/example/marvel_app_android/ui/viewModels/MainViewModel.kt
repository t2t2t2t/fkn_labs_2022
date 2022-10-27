package com.example.marvel_app_android.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val colors = listOf(
        Color(0xFF602325),
        Color.Red,
        Color(0xFF0B0E17),
        Color(0xFF510412),
        Color(0xFF3D464E),
        Color.LightGray,
        Color(0xFF2A3436)

    )

    var backgroundColor by  mutableStateOf(Color.Yellow)



    var snapedItem by mutableStateOf(0)


    fun setColor( col : Int){
        backgroundColor = colors[col]
    }
}
