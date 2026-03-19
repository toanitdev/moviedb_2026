package com.toanitdev.moviedb.presentation.modules.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.toanitdev.moviedb.Routines
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.ui.theme.MovieDBTheme
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun HomeScreen(navController: NavController? = null,viewModel: HomeViewModel = koinViewModel()) {
  val moviesState = viewModel.movies.collectAsLazyPagingItems()
  // Get max width of screen and divide by 2 to get the width of each item
  val itemHeight = (((LocalConfiguration.current.screenWidthDp - 24) / 2) / 2) * 3


  Scaffold(
    modifier = Modifier.fillMaxSize(),
    topBar = {

      TopAppBar(
        title = {
          Text(
            "MooVedi",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2ba08b),
          )
        },
        actions = {
          IconButton(onClick = {
            navController?.navigate(Routines.FAVOURITE.name)
          }) {
            Icon(
              imageVector = Icons.Default.Bookmarks,
              contentDescription = "Search",
              tint = Color.White.copy(alpha = 0.5f)
            )
          }
        }
      )
    }
  ) {
    if (moviesState.itemCount > 0) {
      Column(Modifier.padding(it)) {
        MovieGrid(moviesState, itemHeight)
      }
    } else {
      Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
          CircularProgressIndicator(modifier = Modifier.size(24.dp))
          Text(
            "Loading...",
            modifier = Modifier
              .padding(16.dp)
          )
        }
      }
    }
  }
}

@Composable
fun MovieGrid(movies: LazyPagingItems<Movie>, itemHeight: Int) {
  LazyVerticalGrid(
    columns = GridCells.Fixed(2),
    contentPadding = PaddingValues(12.dp),
    horizontalArrangement = Arrangement.spacedBy(12.dp),
  ) {
    items(count = movies.itemCount) { index ->
      val movie = movies[index]
      movie?.let {
        MovieItem(movie, height = itemHeight)
      }
    }

    when (val state = movies.loadState.append) {
      is LoadState.Loading -> {
        item {
          Text("Loading...", modifier = Modifier.padding(16.dp))
        }
      }

      is LoadState.Error -> {
        item {
          Text(
            "Error: ${state.error.localizedMessage}",
            modifier = Modifier.padding(16.dp),
            color = Color.Red
          )
        }
      }

      else -> Unit
    }
  }
}

@Composable
fun MovieItem(movie: Movie, height: Int = 200) {
  Column {

    Surface(
      color = Color.Gray, modifier = Modifier
        .fillMaxSize()
        .height(height.dp)
    ) {
      val url = "https://image.tmdb.org/t/p/w92" + movie.posterPath
      Box(

        modifier = Modifier
          .height(height.dp)
          .fillMaxWidth(),
        contentAlignment = Alignment.TopStart
      ) {
        AsyncImage(
          url,
          modifier = Modifier
            .height(height.dp)
            .fillMaxWidth()
            .background(Color.Gray.copy(alpha = 0.1f)),
          contentScale = ContentScale.Crop,
          contentDescription = null
        )
        IconButton(onClick = {

        }) {
          Icon(
            imageVector = Icons.Default.BookmarkBorder,
            contentDescription = "Bookmark",
            tint = Color.White.copy(alpha = 0.5f)
          )
        }
      }
    }
    Spacer(Modifier.height(8.dp))
    Text(
      movie.overview,
      fontSize = 12.sp,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
      color = Color.White.copy(alpha = 0.5f)
    )
    Text(
      movie.title,
      fontSize = 14.sp,
      maxLines = 2,
      fontWeight = FontWeight.SemiBold,
      overflow = TextOverflow.Ellipsis
    )

    Spacer(Modifier.height(12.dp))
  }
}

@Preview
@Composable
fun HomeScreenPreview() {
  MovieDBTheme {
    HomeScreen(null)
  }
}