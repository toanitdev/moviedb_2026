package com.toanitdev.moviedb.presentation.modules.details

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.StarHalf
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.toanitdev.moviedb.constants.IMG_POSTER_URL
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.ui.theme.MovieDBTheme
import org.koin.androidx.compose.koinViewModel
import java.util.Locale

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
private fun PreviewMovieDetailScreen() {
  MovieDBTheme {
    MovieDetailContent()
  }
}

@Composable
fun MovieDetailScreen(movieId: Int? = null, viewModel: MovieDetailViewModel = koinViewModel()) {

  val movieState = viewModel.movieDetailState.collectAsState()


  LaunchedEffect(movieId) {
    if (movieId != null) {
      viewModel.loadMovieDetails(movieId)
    }
  }
  when (val state = movieState.value) {
    is MovieDetailState.Loading -> {
      Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Loading...")
      }
    }

    is MovieDetailState.Error -> {
      Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Error: ${state.message}")
      }
    }

    is MovieDetailState.Success -> {
      MovieDetailContent(state.movie)
    }
  }
}

  @SuppressLint("ConfigurationScreenWidthHeight")
  @Composable
  private fun MovieDetailContent(movie: Movie? = null) {

    val configuration = LocalConfiguration.current
    val height = configuration.screenHeightDp.dp
    Scaffold {
      Box(
        modifier = Modifier
          .padding(it)
          .fillMaxSize()
      ) {
        AsyncImage(
          "$IMG_POSTER_URL${movie?.posterPath}",
          contentScale = ContentScale.FillWidth,
          contentDescription = "",
          modifier = Modifier.fillMaxWidth()
        )
        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(
              brush = Brush.linearGradient(
                colorStops = arrayOf(
                  0.0f to Color(0x77141218),
                  0.5f to Color(0xD3141218),
                  0.7f to Color(0xEE141218),
                  1.0f to Color(0xFF141218),
                ),
                start = Offset(0f, 0f),
                end = Offset(0f, 1500f),
              )
            )
        ) {

        }
        Column(
          modifier = Modifier
            .padding(it)
            .padding(top = height / 16f)
            .padding(horizontal = 48.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {

          Surface(
            shadowElevation = 16.dp,
          ) {
            AsyncImage(
              "$IMG_POSTER_URL${movie?.posterPath}",
              contentScale = ContentScale.FillWidth,
              contentDescription = "",
              modifier = Modifier.clip(RoundedCornerShape(4.dp)).width(200.dp).border(1.dp, Color.White.copy(alpha = 0.2f), RoundedCornerShape(4.dp))
            )
          }
          Spacer(Modifier.height(32.dp))
          movie?.title?.uppercase(Locale.ROOT)?.let { text ->
            Text(
              text,
              color = Color.White,
              fontSize = 18.sp,
              fontWeight = FontWeight.SemiBold,
              overflow = TextOverflow.Ellipsis,
              maxLines = 2,
            )
          }
          movie?.overview?.let { text ->
            Text(
              text,
              color = Color.White.copy(alpha = 0.5f),
              fontSize = 14.sp,
              fontWeight = FontWeight.Normal,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis,
            )
          }
          Spacer(Modifier.height(16.dp))
          Row {
            Icon(
              imageVector = Icons.Default.Star,
              contentDescription = null,
              tint = Color(0xFF2ba08b)
            )
            Icon(
              imageVector = Icons.Default.Star,
              contentDescription = null,
              tint = Color(0xFF2ba08b)
            )
            Icon(
              imageVector = Icons.Default.Star,
              contentDescription = null,
              tint = Color(0xFF2ba08b)
            )
            Icon(
              imageVector = Icons.Default.Star,
              contentDescription = null,
              tint = Color(0xFF2ba08b)
            )
            Icon(
              imageVector = Icons.AutoMirrored.Sharp.StarHalf,
              contentDescription = null,
              tint = Color(0xFF2ba08b)
            )
            Text(
              "(4.5)",
              color = Color.White.copy(alpha = 0.5f),
              fontSize = 12.sp,
              modifier = Modifier.padding(start = 4.dp)
            )
          }
          Spacer(Modifier.height(16.dp))
          Row {
            Spacer(modifier = Modifier.weight(1f))
            OutlinedButton(onClick = {
            }) {

              Text("> MORE INFO")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = {

            }) {
              Text("BOOK TICKET")
            }
            Spacer(modifier = Modifier.weight(1f))
          }
        }
      }
    }
  }
