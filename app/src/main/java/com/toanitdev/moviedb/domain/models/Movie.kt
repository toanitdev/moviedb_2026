package com.toanitdev.moviedb.domain.models

import com.google.gson.annotations.SerializedName

data class Movie(
  val id: Int,
  val title: String,
  val overview: String,
  val posterPath: String,
  val releaseDate: String,
  var isFav: Boolean = false,
  var voteAverage: Float,
  var voteCount: Int,
  var productionCompanies: List<ProductionCompany> = emptyList(),
  var genres: List<Genre> = emptyList(),
  var posters: List<Poster> = emptyList()
)