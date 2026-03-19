package com.toanitdev.moviedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.toanitdev.moviedb.presentation.modules.home.HomeScreen
import com.toanitdev.moviedb.ui.theme.MovieDBTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.toanitdev.moviedb.presentation.modules.favourite.FavouriteScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MovieDBTheme {
        Routines()
      }
    }
  }
}


@Composable
fun Routines() {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = Routines.HOME.name) {
    composable(Routines.HOME.name) {
      HomeScreen(navController)
    }
    composable(Routines.FAVOURITE.name) {
      FavouriteScreen(navController)
    }
  }

}


enum class Routines(name: String) {
  HOME("Home"),
  FAVOURITE("Fav"),
  PROFILE("Profile"),
  DETAIL("Detail")
}
