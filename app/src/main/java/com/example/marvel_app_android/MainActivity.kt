package com.example.marvel_app_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.marvel_app_android.ui.navigation.NavigationAppHost

import com.example.marvel_app_android.ui.theme.Marvel_App_AndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Marvel_App_AndroidTheme {
                val navController = rememberNavController()
                NavigationAppHost(navController = navController)
            }
        }
    }
}
