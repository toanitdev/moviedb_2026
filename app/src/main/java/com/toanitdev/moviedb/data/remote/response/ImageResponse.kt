package com.toanitdev.moviedb.data.remote.response

import com.toanitdev.moviedb.data.remote.dto.ImageDto

data class ImageResponse(
  val backdrops: List<ImageDto>,
  val logos: List<ImageDto>,
  val posters: List<ImageDto>,
)
