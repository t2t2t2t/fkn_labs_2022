package com.example.marvel_app_android.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.marvel_app_android.screens.HeroScreen
import com.example.marvel_app_android.screens.HomeScreen


sealed class Destination(val route: String) {
    object Home : Destination("Home")
    object Hero : Destination("Hero/{$ID}"){
        fun passID(id:Int):String{
            return  "Hero/$id"
        }
    }

}

const val ID="id"

@Composable
fun NavigationAppHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "Home") {
        composable(Destination.Home.route) { HomeScreen(navController) }
        composable(Destination.Hero.route, arguments = listOf(navArgument(ID){
            type= NavType.IntType
        })) {
            HeroScreen(navController, it.arguments?.getInt(ID)?:0) }
    }

}