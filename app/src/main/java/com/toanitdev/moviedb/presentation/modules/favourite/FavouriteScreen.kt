package com.toanitdev.moviedb.presentation.modules.favourite

import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import com.toanitdev.moviedb.constants.IMG_POSTER_URL
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
  val favRemovedIds = viewModel.favRemovedIds.collectAsState()

  LaunchedEffect(Unit) {
    viewModel.initLoadFavMovies()
  }

  Scaffold {
    LazyColumn(
      modifier = Modifier.padding(it), contentPadding = PaddingValues(8.dp)
    ) {
      items(favMoviesState.itemCount) { index ->
        val movie = favMoviesState[index] ?: return@items

        if (movie.id in favRemovedIds.value) {
          return@items
        }

        FavItem(movie, onFavClick = {
          viewModel.removeFavMovie(movie.id)
        }, onClick = {
          navController?.navigate("Detail/${movie.id}")
        })
      }
    }
  }
}


@Preview
@Composable
private fun FavouriteScreenPreview() {
  MovieDBTheme {
    FavouriteContent(Gson().fromJson(moviesJson, Array<Movie>::class.java).toList(), onFavClick = {})
  }
}

@Composable
private fun FavouriteContent(movies: List<Movie>, onFavClick: (Movie) -> Unit, onItemClick: (Int) -> Unit = {}) {
  Scaffold {
    LazyColumn(
      modifier = Modifier.padding(it), contentPadding = PaddingValues(8.dp)
    ) {
      items(movies) { item ->
        FavItem(item, onFavClick = {
          onFavClick(item)
        }, onClick = {
          onItemClick(item.id)
        })
      }
    }
  }
}


@Composable
private fun FavItem(movie: Movie, onFavClick: () -> Unit = {}, onClick: () -> Unit = {}) {
  Card(modifier = Modifier.height(120.dp).padding(bottom = 8.dp).clickable(enabled = true, onClick = onClick)) {
    Row {
      AsyncImage(
        IMG_POSTER_URL + movie.posterPath,
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
          onFavClick()
        }) {
          Icon(imageVector = Icons.Default.Bookmark, contentDescription = "Bookmark", tint = Color(0xFF2ba08b))
        }
      }
    }
  }
}
