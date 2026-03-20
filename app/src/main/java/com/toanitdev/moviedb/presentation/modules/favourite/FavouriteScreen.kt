package com.toanitdev.moviedb.presentation.modules.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.google.gson.Gson
import com.toanitdev.moviedb.constants.IMG_URL
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.moviesJson
import com.toanitdev.moviedb.ui.theme.MovieDBTheme
import org.koin.androidx.compose.koinViewModel


@Composable
fun FavouriteScreen(
  navController: NavController? = null,
  viewModel: FavouriteViewModel = koinViewModel()
) {

  val favMoviesState = viewModel.favMovies.collectAsLazyPagingItems()

  Scaffold {
    LazyColumn(
      modifier = Modifier.padding(it),
      verticalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(8.dp)
    ) {
      items(favMoviesState.itemCount) { index ->
        FavItem(favMoviesState[index] ?: return@items)
      }
    }
  }
}


@Preview
@Composable
fun FavouriteScreenPreview() {
  MovieDBTheme {
    FavouriteContent(Gson().fromJson(moviesJson, Array<Movie>::class.java).toList())
  }
}

@Composable
fun FavouriteContent(movies: List<Movie>) {
  Scaffold {
    LazyColumn(
      modifier = Modifier.padding(it),
      verticalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(8.dp)
    ) {
      items(movies) { item ->
        FavItem(item)
      }
    }
  }
}


@Composable
fun FavItem(movie: Movie) {
  Card(modifier = Modifier.height(120.dp)) {
    Row {
      AsyncImage(
        IMG_URL + movie.posterPath,
        contentDescription = null,
        modifier = Modifier
          .height(120.dp)
          .width(120.dp),
        contentScale = ContentScale.Crop
      )
      Column(modifier = Modifier.padding(top = 8.dp, start = 8.dp).weight(1f)) {
        Text(text = movie.title, maxLines = 2, fontWeight = FontWeight.SemiBold)
        Text(text = movie.overview, maxLines = 2)
      }
      Column(modifier = Modifier.width(42.dp), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = {

        }) {
          Icon(imageVector = Icons.Default.Bookmark, contentDescription = "Bookmark", tint = Color(0xFF2ba08b))
        }
      }
    }
  }
}
