package com.toanitdev.moviedb.presentation.modules.booking

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.EventSeat
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.toanitdev.moviedb.ui.theme.Accent
import com.toanitdev.moviedb.ui.theme.BackgroundCard
import com.toanitdev.moviedb.ui.theme.BackgroundDark
import com.toanitdev.moviedb.ui.theme.BackgroundSurface
import com.toanitdev.moviedb.ui.theme.MovieDBTheme
import com.toanitdev.moviedb.ui.theme.Primary
import com.toanitdev.moviedb.ui.theme.PrimaryFaded
import com.toanitdev.moviedb.ui.theme.PrimaryLight
import com.toanitdev.moviedb.ui.theme.SeatAvailable
import com.toanitdev.moviedb.ui.theme.SeatSelected
import com.toanitdev.moviedb.ui.theme.SeatTaken
import com.toanitdev.moviedb.ui.theme.TextMuted
import com.toanitdev.moviedb.ui.theme.TextPrimary
import com.toanitdev.moviedb.ui.theme.TextSecondary
import com.toanitdev.moviedb.ui.theme.TextTertiary


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
    Box(modifier = Modifier.padding(it)) {
      LazyColumn() {
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
                          PrimaryLight,
                          PrimaryFaded,
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
                        0.5f to Primary,
                        1.0f to Color.Transparent,
                      )
                    )
                  )
              ) {

              }
            }
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
              Text(
                "Screen this way".uppercase(),
                color = TextSecondary,
                fontSize = 9.sp,
                letterSpacing = 6.sp
              )
            }
            SeatSelection()

            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
            ) {
              Text(
                "Add popcorn & drinks".uppercase(),
                fontSize = 26.sp,
                color = TextTertiary,
                fontWeight = FontWeight.Black,
                letterSpacing = 0.sp,
                modifier = Modifier.padding(top = 16.dp),
              )
              Spacer(Modifier.height(12.dp))
              Column(
                verticalArrangement = Arrangement.spacedBy(18.dp)
              ) {
                dummyFoods.forEach { food ->
                  FoodItem(food)
                }
                Spacer(Modifier.height(200.dp))
              }
            }

          }
        }
      }

      Column(
        modifier = Modifier
          .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
      ) {
        Box(
          modifier = Modifier
            .fillMaxWidth(),
        ) {

          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
              .drawBehind {
                drawIntoCanvas { canvas ->
                  val paint = Paint().apply {
                    asFrameworkPaint().apply {
                      isAntiAlias = true
                      color = android.graphics.Color.TRANSPARENT
                      setShadowLayer(
                        120f,
                        10f,
                        -80f,
                        android.graphics.Color.argb(30, 43, 160, 139)
                      )
                    }
                  }
                  canvas.drawRoundRect(
                    left = 0f, top = 0f,
                    right = size.width, bottom = size.height,
                    radiusX = 24f, radiusY = 24f,
                    paint = paint
                  )
                }
              }
              .clip(
                shape = RoundedCornerShape(
                  topEnd = 32.dp,
                  topStart = 32.dp,
                )
              )
              .background(BackgroundCard)
              .padding(16.dp)
              .fillMaxWidth()
          ) {
            Text("Total amount".uppercase(), fontSize = 10.sp, color = TextTertiary)
            Text("$44.50", fontSize = 32.sp, color = Accent, fontWeight = FontWeight.Black)
            Spacer(Modifier.height(24.dp))
            Row {
              Row(
                modifier = Modifier
                  .background(
                    color = BackgroundSurface,
                    shape = RoundedCornerShape(6.dp),
                  )
                  .padding(horizontal = 12.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
              ) {
                Icon(
                  Icons.Default.CalendarMonth,
                  contentDescription = null,
                  tint = Primary,
                  modifier = Modifier.size(16.dp)
                )
                Spacer(Modifier.width(12.dp))
                Column {
                  Text(
                    "MAY 24",
                    fontSize = 11.sp,
                    color = TextMuted,
                    lineHeight = 11.sp,
                    fontWeight = FontWeight.Light
                  )
                  Text(
                    "19:30 PM",
                    fontSize = 11.sp,
                    color = TextPrimary,
                    lineHeight = 11.sp,
                    fontWeight = FontWeight.SemiBold
                  )
                }
              }
              Spacer(Modifier.width(12.dp))
              Row(
                modifier = Modifier
                  .background(
                    color = BackgroundSurface,
                    shape = RoundedCornerShape(6.dp),
                  )
                  .padding(horizontal = 12.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
              ) {
                Icon(
                  Icons.Default.EventSeat,
                  contentDescription = null,
                  tint = Primary,
                  modifier = Modifier.size(16.dp)
                )
                Spacer(Modifier.width(12.dp))
                Column {
                  Text(
                    "SEATS",
                    fontSize = 11.sp,
                    color = TextMuted,
                    lineHeight = 11.sp,
                    fontWeight = FontWeight.Light
                  )
                  Text(
                    "A01, A02",
                    fontSize = 11.sp,
                    color = TextPrimary,
                    lineHeight = 11.sp,
                    fontWeight = FontWeight.SemiBold
                  )
                }
              }
            }

            Spacer(Modifier.height(18.dp))
            Button(
              shape = RoundedCornerShape(12.dp),
              onClick = {},
              modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
            ) {
              Text(
                "Booking Confirm".uppercase(),
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
              )
            }
          }
        }
      }
    }
  }
}

//@Preview
@Composable
fun SeatSelectionPreview() {
  MovieDBTheme {
    SeatSelection()
  }
}

@Composable
fun SeatSelection() {
  val seats = dummySeats

  Column(
    verticalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp)
  ) {
    seats.forEachIndexed { index, row ->
      Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        seats[index].forEachIndexed { index, seat ->
          Box(contentAlignment = Alignment.Center) {
            when (seat) {
              0 -> RoadItem()
              1 -> SeatEmptyItem()
              2 -> SeatTakenItem()
              3 -> SeatSelectedItem()
              4 -> SeatVipItem()
            }
          }
        }
      }
    }

    Row(
      horizontalArrangement = Arrangement.SpaceAround,
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Surface(
          shape = RoundedCornerShape(2.dp),
          color = SeatAvailable,
          modifier = Modifier.size(12.dp)
        ) {

        }
        Spacer(Modifier.width(8.dp))
        Text("Available".uppercase(), fontSize = 10.sp, color = TextTertiary)
      }
      Row(verticalAlignment = Alignment.CenterVertically) {
        Surface(
          shape = RoundedCornerShape(2.dp),
          color = SeatSelected,
          modifier = Modifier.size(12.dp)
        ) {

        }
        Spacer(Modifier.width(8.dp))
        Text("Selected".uppercase(), fontSize = 10.sp, color = Accent)
      }
      Row(verticalAlignment = Alignment.CenterVertically) {
        Surface(
          shape = RoundedCornerShape(2.dp),
          color = SeatTaken,
          modifier = Modifier.size(12.dp)
        ) {

        }
        Spacer(Modifier.width(8.dp))
        Text("Taken".uppercase(), fontSize = 10.sp, color = TextTertiary)
      }
    }
  }
}

//@Preview
@Composable
fun SeatItemPreview() {
  MovieDBTheme {
    Row(
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      SeatEmptyItem()
      RoadItem()
      SeatTakenItem()
      SeatSelectedItem()
      SeatVipItem()
    }
  }
}

@Composable
fun SeatEmptyItem(name: String = "A1") {
  Box(
    modifier = Modifier
      .size(32.dp)
      .clip(shape = RoundedCornerShape(8.dp))
      .background(SeatAvailable),
    contentAlignment = Alignment.Center
  ) {
    Icon(
      imageVector = Icons.Default.EventSeat,
      contentDescription = "Seat",
      tint = TextPrimary.copy(alpha = 0.85f),
      modifier = Modifier.size(16.dp)
    )
  }
}

@Composable
fun RoadItem(name: String = "A1") {
  Box(
    modifier = Modifier
      .size(height = 8.dp, width = 32.dp),
    contentAlignment = Alignment.Center
  ) {
  }
}

@Composable
fun SeatTakenItem(name: String = "A1") {
  Box(
    modifier = Modifier
      .size(32.dp)
      .clip(shape = RoundedCornerShape(8.dp))
      .background(SeatTaken),
    contentAlignment = Alignment.Center
  ) {
    Icon(
      imageVector = Icons.Default.EventSeat,
      contentDescription = "Seat",
      tint = TextPrimary.copy(alpha = 0.3f),
      modifier = Modifier.size(16.dp)
    )
  }
}

@Composable
fun SeatSelectedItem(name: String = "A1") {
  Box(
    modifier = Modifier
      .size(32.dp)
      .clip(shape = RoundedCornerShape(8.dp))
      .background(SeatSelected),
    contentAlignment = Alignment.Center
  ) {
    Icon(
      imageVector = Icons.Default.Check,
      contentDescription = "Seat",
      tint = Color.Black,
      modifier = Modifier.size(14.dp)
    )
  }
}

@Composable
fun SeatVipItem(name: String = "A1") {
  Box(
    modifier = Modifier
      .size(32.dp)
      .clip(shape = RoundedCornerShape(8.dp))
      .background(SeatAvailable)
      .border(0.5.dp, Accent, shape = RoundedCornerShape(8.dp)),
    contentAlignment = Alignment.Center
  ) {
    Icon(
      imageVector = Icons.Default.Stars,
      contentDescription = "Seat",
      tint = Accent,
      modifier = Modifier.size(14.dp)
    )
  }
}

@Composable
fun FoodItem(food: Food) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .aspectRatio(1f)
      .clip(RoundedCornerShape(12.dp))
  ) {
    AsyncImage(
      food.imageUrl,
      contentDescription = null,
      modifier = Modifier.fillMaxWidth(),
      contentScale = androidx.compose.ui.layout.ContentScale.Crop
    )
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
      verticalArrangement = Arrangement.Bottom
    ) {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f)
          .background(
            Brush.verticalGradient(
              colorStops = arrayOf(
                0.0f to Color.Transparent,
                0.8f to Color(0x9F222026),
                1.0f to Color(0xFF222026),
              )
            )
          )
      ) {

      }
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(Color(0xFF222026))
          .padding(24.dp)
      ) {
        Row {
          Text(
            food.name.uppercase(),
            color = TextPrimary,
            fontSize = 21.sp,
            fontWeight = FontWeight.Black,
            letterSpacing = 0.sp
          )
          Spacer(Modifier.weight(1f))
          Text(
            "$${food.price}",
            color = Accent,
            fontSize = 21.sp,
            fontWeight = FontWeight.Black,
            letterSpacing = 0.sp
          )
        }
        Spacer(Modifier.height(12.dp))
        Text(food.desciption, color = TextSecondary, fontSize = 14.sp)
        Spacer(Modifier.height(16.dp))
        Row(
          verticalAlignment = Alignment.Bottom,
          horizontalArrangement = Arrangement.SpaceBetween,
          modifier = Modifier.fillMaxWidth()
        ) {
          QuantitySelector()
          IconButton(onClick = {}) {
            Icon(
              imageVector = Icons.Outlined.ShoppingBag,
              contentDescription = null,
              tint = Primary
            )
          }
        }
      }
    }
  }
}

@Composable
fun QuantitySelector() {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .clip(shape = RoundedCornerShape(16.dp))
      .background(BackgroundSurface)
      .padding(8.dp)
  ) {

    Spacer(modifier = Modifier.width(4.dp))
    IconButton({

    }, Modifier.size(18.dp)) {
      Icon(
        imageVector =
          Icons.Default.Remove, contentDescription = null, tint = TextPrimary
      )
    }

    Spacer(modifier = Modifier.width(12.dp))
    Text(
      "1",
      color = TextPrimary,
      fontSize = 17.sp,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.padding(horizontal = 12.dp)
    )
    Spacer(modifier = Modifier.width(12.dp))
    IconButton({

    }, Modifier.size(18.dp)) {
      Icon(
        imageVector =
          Icons.Default.Add, contentDescription = null, tint = TextPrimary
      )
    }

    Spacer(modifier = Modifier.width(4.dp))
  }
}


val dummyFoods = listOf(
  Food(
    name = "SOLO PREMIERE",
    desciption = "Medium Popcorn + 500ml Soda of choice",
    price = 12.50,
    imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuCtDyXb_TmTdMiCAjd7wZ-oBfRjWN_TnLW0vgbZ5mhMo-aop_woTaqunGXOcQWQOQpVHuokKuDWJg98_pxuQOBVt2fhc4tQh9vQV5MZEYlZBIurXd-ZJv_JBbJXceWRD0rAnvpinOICqoNGHkS7PdvvpwCsmmHOjtktvnNRFo0tw-MIvrm2ExWBW2F2WgOZVGgC71cr_apI42eHyf41wItDV_OlZAiu4yKTp3XvR_BulAzAdylvfjqp3Sn5NqfmGUHVT1QBnCMmG-o"
  ),
  Food(
    name = "DUO SPECTACLE",
    desciption = "Large Popcorn + 2 Large Sodas + Nachos",
    price = 12.50,
    imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuCOb5EARsUCl4Pj_ClzlwZR2ZM03x4twbZb_x087u_JW20FP4F3EJ3dw_GKDGqC7VRHI6HaR_SmLPC94AgS1DbHbSCXjfdgBPtDc_jbBC7-bwv06uk9f7wKv-4Yqhyqn1C1yzNrPT9EuWpd9ayNgOGF6u6Wq86V-FpwW3kAa4BjF3G1rM8GsDGOj2rkqy_b4tPY0YMOyFFFYIZpLRF9QDhFifJjbJ85y8ryNX3XXl-WR1gq4l9oE9-BNdeLjIxZcux7-g1Xf1Z0bK8"
  ),
  Food(
    name = "AUTEUR BOX",
    desciption = "Gourmet Truffle Popcorn + Craft Mocktail",
    price = 12.50,
    imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuArfu2MHoalr6JJl3K6SLrnYu8YaeGKeeC3XFWMqjFOENBGh1lOzQ5Zf1RqZtnkNywq2zkhQ3HH3vaArb1ulHJItsSIsbG9DLZmAiEw8V1T2b85ruXYRri2fl_LrNXNt5iLA3k7TCNrpYL7Vu66CtMWkNSg03-kkmIvrDPaOp-M79372IZKe9bZpAT5lZtPdtWCTow5QYM1Yg-ZDR3X6BNX4YNM2ucsGrlUBajtmJSn1actsOhaZABTjnP8aJA9ffPCuBilZBVwSVU"
  ),
)

data class Food(
  val name: String,
  val desciption: String,
  val price: Double,
  val imageUrl: String
)


// 1: Ghế trống
// 0: Đường đi/không có ghế
// 2: Ghế đã đặt
// 3: Ghế đang chọn
// 4: Ghế VIP


val dummySeats = listOf(
  listOf<Int>(
    2, 2, 1, 0, 3, 3, 0, 1, 1, 2
  ),
  listOf<Int>(
    1, 1, 1, 0, 1, 1, 0, 1, 1, 1
  ),
  listOf<Int>(
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0
  ),
  listOf<Int>(
    4, 4, 4, 0, 4, 4, 0, 4, 4, 4
  ),
)
