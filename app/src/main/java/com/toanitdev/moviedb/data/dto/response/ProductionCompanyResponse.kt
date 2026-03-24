package com.toanitdev.moviedb.data.dto.response

import com.google.gson.annotations.SerializedName
import com.toanitdev.moviedb.domain.models.ProductionCompany

data class ProductionCompanyResponse(
  val id: Int,
  @SerializedName("logo_path")
  val logoPath: String?,
  val name: String,
  @SerializedName("origin_country")
  val originCountry: String
) {
  fun toProductionCompany(): ProductionCompany {
    return ProductionCompany(
      id = id,
      logoPath = logoPath,
      name = name,
      originCountry = originCountry
    )
  }
}
