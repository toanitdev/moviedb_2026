package com.toanitdev.moviedb.data.remote.request

import com.google.gson.annotations.SerializedName

data class SetFavMovieRequest(
  @SerializedName("media_type")
  val mediaType: String,
  @SerializedName("media_id")
  val mediaId: Int,
  val favorite: Boolean
)
