package com.toanitdev.moviedb.domain.models

data class Cast(
  val id: Int,
  val name: String,
  val character: String,
  val profilePath: String?
)