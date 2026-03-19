package com.toanitdev.moviedb.presentation.modules.home

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.movies
import com.toanitdev.moviedb.ui.theme.MovieDBTheme
import org.koin.androidx.compose.koinViewModel


@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
  val moviesState = viewModel.homeStateFlow.collectAsState()

  LaunchedEffect(Unit) {
    viewModel.fetchDiscoverMovies()
  }

  // Get max width of screen and divide by 2 to get the width of each item
  val itemHeight = (((LocalConfiguration.current.screenWidthDp - 24) / 2)/2)*3


  Scaffold {

    Column(Modifier.padding(it)) {
      when(moviesState.value) {
        is HomeState.Loading -> Text("Loading...")
        is HomeState.Failure -> Text("Error: ${(moviesState.value as HomeState.Failure).error.message}")
        is HomeState.Success -> {
          val moviesList = (moviesState.value as HomeState.Success).movies
          MovieGrid(moviesList, itemHeight)
        }

        is HomeState.Initial -> {

        }
      }
    }

  }
}
@Composable
fun MovieGrid(movie: List<Movie>, itemHeight: Int) {
  LazyVerticalGrid(
    columns = GridCells.Fixed(2),
    contentPadding = PaddingValues(12.dp),
    horizontalArrangement = Arrangement.spacedBy(12.dp),
  ) {
    items(movie) {
      MovieItem(it, height = itemHeight)
    }
  }
}

@Composable
fun MovieItem(movie: Movie, height: Int = 200) {
  Column {

    Surface(color = Color.Gray, modifier = Modifier
      .fillMaxSize()
      .height(height.dp)
    ) {
      val url = "https://image.tmdb.org/t/p/w92" + movie.posterPath
      AsyncImage(
        url,
        modifier = Modifier
          .height(height.dp)
          .width(100.dp)
          .background(Color.Gray.copy(alpha = 0.1f)),
        contentScale = ContentScale.Crop,
        contentDescription = null
      )


    }
    Spacer(Modifier.height(8.dp))
    Text(movie.overview, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis, color = Color.White.copy(alpha = 0.5f))
    Text(movie.title, fontSize = 14.sp,maxLines = 2, fontWeight = FontWeight.SemiBold, overflow = TextOverflow.Ellipsis)

    Spacer(Modifier.height(12.dp))
  }
}

@Preview
@Composable
fun HomeScreenPreview() {
  MovieDBTheme {
    HomeScreen()
  }
}