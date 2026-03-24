package com.toanitdev.moviedb.data.remote.sevices

import com.toanitdev.moviedb.data.dto.request.SetFavMovieRequest
import com.toanitdev.moviedb.data.dto.response.ImageResponse
import com.toanitdev.moviedb.data.dto.response.ResultResponse
import com.toanitdev.moviedb.data.dto.response.ListResponse
import com.toanitdev.moviedb.data.dto.response.MovieResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDBService {

  @GET("discover/movie?include_adult=false&include_video=false&language=en-US&sort_by=popularity.desc")
  suspend fun getDiscoverMovies(@Query("page") page: Int = 1) : ListResponse<MovieResponse>



  @GET("account/18556593/favorite/movies")
  suspend fun getFavMovies(@Query("page") page: Int = 1) : ListResponse<MovieResponse>

  @POST("account/18556593/favorite")
  suspend fun setFavMovie(@Body request: SetFavMovieRequest) : ResultResponse

  @GET("movie/{movie_id}")
  suspend fun getMovieDetails(@Path("movie_id") movieId: Int) : MovieResponse


  @GET("movie/{movie_id}/images?include_image_language=en-US")
  suspend fun getMovieImages(@Path("movie_id") movieId: Int) : ImageResponse


}