package com.toanitdev.moviedb.data.dto.response

import com.toanitdev.moviedb.domain.models.Genre

data class GenreResponse(
  val id: Int,
  val name: String) {
  fun toGenre(): Genre {
    return Genre(
      id = id,
      name = name
    )
  }
}