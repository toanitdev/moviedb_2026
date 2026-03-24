package com.toanitdev.moviedb.domain.models

data class ProductionCompany(
  val id: Int,
  val logoPath: String?,
  val name: String,
  val originCountry: String
)