package com.toanitdev.moviedb.data.remote.response

import com.toanitdev.moviedb.data.remote.dto.CastDto

data class CreditResponse(
  val id: Int,
  val cast: List<CastDto>
)
