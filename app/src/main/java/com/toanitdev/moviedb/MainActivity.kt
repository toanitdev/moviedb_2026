package com.toanitdev.moviedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.toanitdev.moviedb.presentation.modules.details.MovieDetailScreen
import com.toanitdev.moviedb.presentation.modules.favourite.FavouriteScreen
import com.toanitdev.moviedb.presentation.modules.home.HomeScreen
import com.toanitdev.moviedb.ui.theme.MovieDBTheme

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

    composable(
      Routines.DETAIL.name + "/{movieId}",
      arguments = listOf(
        navArgument("movieId") { type = NavType.IntType }
      )) { backStackEntry ->
      val movieId = backStackEntry.arguments?.getInt("movieId")
      MovieDetailScreen(navController, movieId)
    }
  }

}


enum class Routines(name: String) {
  HOME("Home"),
  FAVOURITE("Fav"),
  PROFILE("Profile"),
  DETAIL("Detail/{movieId}"),
}
