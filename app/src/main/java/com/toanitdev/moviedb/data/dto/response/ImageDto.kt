package com.toanitdev.moviedb.data.dto.response

import com.google.gson.annotations.SerializedName

data class ImageDto(
  @SerializedName("file_path")
  val filePath: String,
  val width: Int,
  val height: Int
)
