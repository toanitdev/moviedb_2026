package com.toanitdev.moviedb.data.dto.response

import com.toanitdev.moviedb.domain.models.Poster

data class ImageResponse(
  val backdrops: List<ImageDto>,
  val logos: List<ImageDto>,
  val posters: List<ImageDto>,
)
