package com.toanitdev.moviedb.data.remote.sevices

import com.toanitdev.moviedb.domain.models.ListResponse
import com.toanitdev.moviedb.domain.models.Movie
import retrofit2.http.GET

interface MovieDBService {

  @GET("discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc")
  suspend fun getDiscoverMovies() : ListResponse

}