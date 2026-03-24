package com.toanitdev.moviedb.presentation.modules.booking

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toanitdev.moviedb.ui.theme.MovieDBTheme


@Preview
@Composable
fun BookingScreenPreview() {
  MovieDBTheme {
    BookingScreen()
  }
}


@Composable
fun BookingScreen() {
  Scaffold {
    LazyColumn(modifier = Modifier.padding(it)) {
      item {
        Column(modifier = Modifier.fillMaxWidth()) {

          Spacer(Modifier.height(8.dp))
          Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
              .height(28.dp)
          ) {
            Canvas(
              modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
            ) {
              val ovalWidth = size.width
              val ovalHeight = size.height

              clipPath(
                Path().apply {
                  addOval(Rect(0f, 0f, ovalWidth, ovalHeight))
                } as Path
              ) {
                scale(
                  scaleX = ovalWidth / ovalHeight,
                  scaleY = 1f,
                  pivot = center
                ) {
                  drawCircle(
                    brush = Brush.radialGradient(
                      colors = listOf(
                        Color(0x3B2BA08B),
                        Color(0x032BA08B),
                      ),
                      center = center,
                      radius = ovalHeight / 2f
                    ),
                    radius = ovalHeight / 2f,
                    center = center
                  )
                }
              }
            }
            Box(
              modifier = Modifier
                .height(6.dp)
                .fillMaxWidth()
                .background(
                  brush = Brush.linearGradient(
                    colorStops = arrayOf(
                      0.0f to Color.Transparent,
                      0.5f to Color(0xFF2ba08b),
                      1.0f to Color.Transparent,
                    )
                  )
                )
            ) {

            }
          }
          Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Text("Screen this way".uppercase(), color = Color(0xB3FFFFFF), fontSize = 12.sp)
          }


          LazyVerticalGrid (
            columns = GridCells.Fixed(count = 8),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
              .padding(16.dp)
              .height(180.dp)
              .fillMaxWidth()
          ) {
            items(32) {
              Box(contentAlignment = Alignment.Center) {

                Box(
                  modifier = Modifier
                    .size(24.dp)
                    .background(Color.Gray.copy(alpha = 0.3f)),
                  contentAlignment = Alignment.Center
                ) {
                  Text("A${it+1}", color = Color.White, fontSize = 12.sp)
                }
              }
            }
          }
        }
      }
    }
  }
}
