package com.toanitdev.moviedb.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
  val id: Int,
  val title: String,
  val overview: String,
  @SerializedName("poster_path")
  val posterPath: String,
  @SerializedName("release_date")
  val releaseDate: String,
  @SerializedName("vote_average")
  var voteAverage: Float,
  @SerializedName("vote_count")
  var voteCount: Int,
  @SerializedName("production_companies")
  val productionCompanies: List<ProductionCompanyDto>? = emptyList(),
  @SerializedName("genres")
  val genres: List<GenreDto>? = emptyList(),
  var isFav: Boolean = false,
)