package com.toanitdev.moviedb.domain.models

import com.google.gson.annotations.SerializedName

data class ListResponse(
  val page: Int,
  val results: List<Movie>,
  @SerializedName("total_pages")
  val totalPages: Int,
  @SerializedName("total_results")
  val totalResults: Int
)
