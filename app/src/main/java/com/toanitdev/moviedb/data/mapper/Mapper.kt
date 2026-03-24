package com.toanitdev.moviedb.data.mapper

import com.toanitdev.moviedb.data.remote.dto.GenreDto
import com.toanitdev.moviedb.data.remote.dto.MovieDto
import com.toanitdev.moviedb.data.remote.dto.ProductionCompanyDto
import com.toanitdev.moviedb.domain.models.Genre
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.models.ProductionCompany


fun ProductionCompanyDto.toDomain(): ProductionCompany {
  return ProductionCompany(
    id = this.id,
    logoPath = this.logoPath,
    name = this.name,
    originCountry = this.originCountry
  )
}

fun GenreDto.toDomain(): Genre {
  return Genre(
    id = this.id,
    name = this.name
  )
}



fun MovieDto.toDomain(): Movie {
  return Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterPath = this.posterPath,
    releaseDate = this.releaseDate,
    isFav = this.isFav,
    voteAverage = this.voteAverage,
    voteCount = this.voteCount,
    productionCompanies = this.productionCompanies?.map { it.toDomain() } ?: emptyList(),
    genres = this.genres?.map { it.toDomain() } ?: emptyList()
  )
}