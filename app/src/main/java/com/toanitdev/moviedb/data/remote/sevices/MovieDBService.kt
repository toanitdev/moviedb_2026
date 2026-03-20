package com.toanitdev.moviedb.data.remote.sevices

import com.toanitdev.moviedb.data.model.request.SetFavMovieRequest
import com.toanitdev.moviedb.data.model.response.ResultResponse
import com.toanitdev.moviedb.domain.models.ListResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MovieDBService {

  @GET("discover/movie?include_adult=false&include_video=false&language=en-US&sort_by=popularity.desc")
  suspend fun getDiscoverMovies(@Query("page") page: Int = 1) : ListResponse



  @GET("account/18556593/favorite/movies")
  suspend fun getFavMovies(@Query("page") page: Int = 1) : ListResponse

  @POST("account/18556593/favorite")
  suspend fun setFavMovie(@Body request: SetFavMovieRequest) : ResultResponse


}