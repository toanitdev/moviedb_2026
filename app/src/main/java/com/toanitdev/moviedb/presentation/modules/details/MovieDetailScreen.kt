package com.toanitdev.moviedb.presentation.modules.details

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBackIos
import androidx.compose.material.icons.automirrored.rounded.ArrowLeft
import androidx.compose.material.icons.automirrored.sharp.StarHalf
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.toanitdev.moviedb.constants.IMG_LOGO_URL
import com.toanitdev.moviedb.constants.IMG_POSTER_URL
import com.toanitdev.moviedb.constants.IMG_PROFILE_URL
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
fun MovieDetailScreen(navController: NavController? = null, movieId: Int?, viewModel: MovieDetailViewModel = koinViewModel()) {

  val movieState = viewModel.movieDetailState.collectAsState()


  LaunchedEffect(movieId) {
    if (movieId != null) {
      viewModel.loadMovieDetails(movieId)
    }
  }

  Scaffold{
    Box(
      modifier = Modifier
        .padding(it)
        .fillMaxSize(), contentAlignment = Alignment.TopStart
    ) {
      Row(
        modifier = Modifier.padding(12.dp).fillMaxWidth().zIndex(100f),
        verticalAlignment = Alignment.CenterVertically
      ) {
        IconButton(onClick = {
          navController?.popBackStack()
        }) {
          Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBackIos, contentDescription = null, tint = Color.White)
        }
      }
      when (val state = movieState.value) {
        is MovieDetailState.Loading -> {


          Box(
            modifier = Modifier
              .padding(it)
              .fillMaxSize(), contentAlignment = Alignment.Center
          ) {
            Row(
              Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.Center,
              verticalAlignment = Alignment.CenterVertically
            ) {
              CircularProgressIndicator(modifier = Modifier.size(24.dp))
              Text(
                "Loading...",
                modifier = Modifier
                  .padding(16.dp)
              )
            }
          }

        }

        is MovieDetailState.Error -> {

          Box(
            modifier = Modifier
              .padding(it)
              .fillMaxSize(), contentAlignment = Alignment.Center
          ) {
            Text("Error: ${state.message}")
          }

        }

        is MovieDetailState.Success -> {
          MovieDetailContent(state.movie)
        }
      }
    }
  }

}

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
private fun MovieDetailContent(movie: Movie? = null) {

  val configuration = LocalConfiguration.current
  val height = configuration.screenHeightDp.dp
  Box(
    modifier = Modifier
      .fillMaxSize(),
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
    LazyColumn(
      modifier = Modifier
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {

      item() {
        Spacer(Modifier.height(height / 14f))
        movie?.posters?.let { posters ->
          LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 48.dp)
          ) {
            items(posters.take(5)) { poster ->
              Surface(
                shadowElevation = 16.dp,
              ) {
                AsyncImage(
                  "$IMG_POSTER_URL${poster.filePath}",
                  contentScale = ContentScale.FillBounds,
                  contentDescription = "",
                  modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .width(200.dp)
                    .height(300.dp)
                    .border(1.dp, Color.White.copy(alpha = 0.2f), RoundedCornerShape(4.dp))
                )
              }
            }
          }
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
            modifier = Modifier
              .padding(horizontal = 48.dp)
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
            modifier = Modifier
              .padding(horizontal = 48.dp)
          )
        }
        Spacer(Modifier.height(16.dp))
        Row(
          modifier = Modifier
            .padding(horizontal = 48.dp)
        ) {
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
            "${movie?.voteAverage ?: 0.0} (${movie?.voteCount ?: 0} votes)",
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

        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(
          Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
          horizontalArrangement = Arrangement.Center
        ) {
          movie?.genres?.forEach { genre ->
            Button(
              onClick = {},
              modifier = Modifier
                .padding(4.dp)
                .height(24.dp),
              contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
            ) {
              Text(
                genre.name,
                fontSize = 11.sp
              )
            }

          }
        }
        Column(
          modifier = Modifier
            .padding(horizontal = 16.dp)
        ) {
          Text(
            "Overview",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 16.dp)
          )
          Spacer(modifier = Modifier.height(8.dp))
          Text(
            movie?.overview ?: "",
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 12.sp,
            lineHeight = 17.sp,
            fontWeight = FontWeight.Normal
          )


          Text(
            "Casts",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 16.dp)
          )

          Spacer(modifier = Modifier.height(8.dp))
          LazyRow {
            items(movie?.casts ?: emptyList()) { company ->
              Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                  .padding(end = 8.dp)
                  .width(120.dp),

                ) {
                Box(contentAlignment = Alignment.BottomStart) {
                  AsyncImage(
                    "$IMG_PROFILE_URL${company.profilePath}",
                    contentScale = ContentScale.FillWidth,
                    contentDescription = "",
                    modifier = Modifier
                      .clip(RoundedCornerShape(4.dp))
                      .width(120.dp)
                      .height(180.dp)
                      .background(Color.White)
                  )
                  Box(
                    modifier = Modifier
                      .width(120.dp)
                      .height(180.dp)
                      .background(
                        brush = Brush.linearGradient(
                          colorStops = arrayOf(
                            0.0f to Color(0x26141218),
                            0.6f to Color(0x26141218),
                            1.0f to Color(0xA6141218),
                          ),
                          start = Offset(0f, 0f),
                          end = Offset(0f, 360f),
                        )
                      )
                  ) {

                  }
                  Column(
                    modifier = Modifier.padding(6.dp),
                    verticalArrangement = Arrangement.Bottom
                  ) {
                    Text(
                      company.name,
                      color = Color.White,
                      fontSize = 14.sp,
                      fontWeight = FontWeight.SemiBold,
                      maxLines = 2,
                      lineHeight = 17.sp,
                      overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                      company.character,
                      color = Color.White.copy(alpha = 0.6f),
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Normal,
                      maxLines = 2,
                      lineHeight = 17.sp,
                      overflow = TextOverflow.Ellipsis,
                    )
                  }
                }
              }
            }
          }

          Text(
            "Production Companies",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 16.dp)
          )

          Spacer(modifier = Modifier.height(8.dp))
          LazyRow {
            items(movie?.productionCompanies ?: emptyList()) { company ->
              Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                  .padding(end = 8.dp)
                  .width(120.dp),

                ) {
                AsyncImage(
                  "$IMG_LOGO_URL${company.logoPath}",
                  contentScale = ContentScale.FillWidth,
                  contentDescription = "",
                  modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .width(120.dp)
                    .height(120.dp)
                    .background(Color.White)
                    .padding(8.dp)
                    .border(1.dp, Color.White.copy(alpha = 0.2f), RoundedCornerShape(4.dp))
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  company.name,
                  color = Color.White.copy(alpha = 0.8f),
                  fontSize = 14.sp,
                  fontWeight = FontWeight.Normal,
                  maxLines = 2,
                  lineHeight = 17.sp,
                  overflow = TextOverflow.Ellipsis,
                )
              }
            }
          }
        }
      }
      item {
        Spacer(modifier = Modifier.height(120.dp))
      }
    }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
      Box(
        modifier = Modifier
          .height(100.dp)
          .fillMaxWidth()
          .background(Color(0xFF212128))
          .padding(18.dp)
      ) {
        Row {
          Column(
            modifier = Modifier.fillMaxHeight(),
          ) {
            Text(
              "STARTING\nFROM",
              color = Color.White.copy(alpha = 0.5f),
              fontSize = 12.sp,
              lineHeight = 15.sp,
            )

            Text(
              "$10.99",
              color = Color.White,
              fontSize = 28.sp,
              fontWeight = FontWeight.Black
            )
          }
          Spacer(modifier = Modifier.width(24.dp))
          Button(
            onClick = {},
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
          ) {
            Text("SELECT\nSHOWTIME", textAlign = TextAlign.Center)
          }
        }
      }

    }
  }
}
