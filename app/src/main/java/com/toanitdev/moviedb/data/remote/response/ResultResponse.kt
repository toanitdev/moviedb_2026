package com.toanitdev.moviedb.data.remote.response

import com.google.gson.annotations.SerializedName

data class ResultResponse(
  val success: Boolean,
  @SerializedName("status_code")
  val statusCode: Int,
  @SerializedName("status_message")
  val statusMessage: String
)