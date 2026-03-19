package com.toanitdev.moviedb.domain.models

data class ListResponse(
  val page: Int,
  val results: List<Movie>,
  val total_pages: Int,
  val total_results: Int
)
