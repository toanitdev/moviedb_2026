package com.toanitdev.moviedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import com.toanitdev.moviedb.presentation.modules.booking.BookingScreen
import com.toanitdev.moviedb.presentation.modules.details.MovieDetailScreen
import com.toanitdev.moviedb.presentation.modules.favourite.FavouriteScreen
import com.toanitdev.moviedb.presentation.modules.home.HomeScreen
import com.toanitdev.moviedb.ui.theme.MovieDBTheme
import kotlinx.serialization.Serializable

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

val LocalNavController = compositionLocalOf<NavHostController> {
  error("No NavController provided")
}
@Composable
fun Routines() {
  val navController = rememberNavController()
  CompositionLocalProvider(
    LocalNavController provides navController
  ) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
      composable(Screen.Home.route) {
        HomeScreen()
      }
      composable(Screen.Favourite.route) {
        FavouriteScreen(navController)
      }

      composable(Screen.Detail.route,
        arguments = listOf(
          navArgument("movieId") {
            type = NavType.IntType
          }
        ),
//      deepLinks = listOf(
//        navDeepLink {
//
//          action = "com.toan.OPEN_DETAIL"
//          uriPattern = "myapp://detail/{movieId}"
//        }
//      )
      ) { backStackEntry ->
        val movieId = backStackEntry.arguments?.getInt("movieId")
        MovieDetailScreen(navController, movieId)
      }
      composable(
        Screen.Booking.route,) {
        BookingScreen()
      }

      composable<DeteoScreen>(
        deepLinks = listOf(
          navDeepLink {

            action = "com.toan.OPEN_DETAIL"
            uriPattern = "myapp://detail/{id}" // id phải trùng với tên attribute trong DeteoScreen
          }
        )
      ) { backStackEntry ->
        val detail: DeteoScreen = backStackEntry.toRoute()
        MovieDetailScreen(navController,detail.id)
      }
    }

  }

}

@Serializable
data class DeteoScreen(val id: Int)

sealed class Screen(val route: String) {
  object Home: Screen("Home")
  object Favourite: Screen("Fav")
  object Profile: Screen("Profile")
  object Detail: Screen("Detail/{movieId}") {
    fun createRoute(movieId: Int) = "Detail/$movieId"
  }
  object Booking: Screen("Booking")
}
