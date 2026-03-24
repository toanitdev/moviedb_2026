package com.toanitdev.moviedb.data.remote.dto

data class CastDto(
  val adult: Boolean,
  val gender: Int,
  val id: Int,
  val known_for_department: String,
  val name: String,
  val character: String,
  val profile_path: String,
)