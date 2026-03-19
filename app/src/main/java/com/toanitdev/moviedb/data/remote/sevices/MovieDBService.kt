package com.toanitdev.moviedb.data.remote.sevices

import com.toanitdev.moviedb.domain.models.ListResponse
import com.toanitdev.moviedb.domain.models.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBService {

  @GET("discover/movie?include_adult=false&include_video=false&language=en-US&sort_by=popularity.desc")
  suspend fun getDiscoverMovies(@Query("page") page: Int = 1) : ListResponse

}