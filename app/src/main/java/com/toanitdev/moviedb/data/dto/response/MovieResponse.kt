package com.toanitdev.moviedb.data.dto.response

import com.google.gson.annotations.SerializedName
import com.toanitdev.moviedb.domain.models.Movie

data class MovieResponse(
  val id: Int,
  val title: String,
  val overview: String,
  @SerializedName("poster_path")
  val posterPath: String,
  @SerializedName("release_date")
  val releaseDate: String,
  @SerializedName("vote_average")
  val voteAverage: Float,
  @SerializedName("vote_count")
  val voteCount: Int,
  @SerializedName("genres")
  val genres: List<GenreResponse>?,
  @SerializedName("production_companies")
  val productionCompanies: List<ProductionCompanyResponse>?,
  var isFav: Boolean = false
) {
  fun toMovie(): Movie {
    return Movie(
      id = id,
      title = title,
      overview = overview,
      posterPath = posterPath,
      releaseDate = releaseDate,
      isFav = isFav,
      productionCompanies = productionCompanies?.map { it.toProductionCompany() } ?: emptyList(),
      genres = genres?.map { it.toGenre() } ?: emptyList(),
      voteAverage = voteAverage,
      voteCount = voteCount
    )
  }
}