package com.toanitdev.moviedb.data.dto.response

import com.google.gson.annotations.SerializedName
import com.toanitdev.moviedb.domain.models.Movie
data class ListResponse<T>(
  val page: Int,
  val results: List<T>,
  @SerializedName("total_pages")
  val totalPages: Int,
  @SerializedName("total_results")
  val totalResults: Int
)