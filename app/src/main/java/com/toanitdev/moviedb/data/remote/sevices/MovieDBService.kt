package com.toanitdev.moviedb.data.remote.sevices

import com.toanitdev.moviedb.data.remote.dto.MovieDto
import com.toanitdev.moviedb.data.remote.request.SetFavMovieRequest
import com.toanitdev.moviedb.data.remote.response.CreditResponse
import com.toanitdev.moviedb.data.remote.response.ImageResponse
import com.toanitdev.moviedb.data.remote.response.PagingResponse
import com.toanitdev.moviedb.data.remote.response.ResultResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDBService {

  @GET("discover/movie?include_adult=false&include_video=false&language=en-US&sort_by=popularity.desc")
  suspend fun getDiscoverMovies(@Query("page") page: Int = 1): PagingResponse<MovieDto>


  @GET("account/18556593/favorite/movies")
  suspend fun getFavMovies(@Query("page") page: Int = 1): PagingResponse<MovieDto>

  @POST("account/18556593/favorite")
  suspend fun setFavMovie(@Body request: SetFavMovieRequest): ResultResponse

  @GET("movie/{movie_id}")
  suspend fun getMovieDetails(@Path("movie_id") movieId: Int): MovieDto


  @GET("movie/{movie_id}/images?include_image_language=en-US")
  suspend fun getMovieImages(@Path("movie_id") movieId: Int): ImageResponse


  @GET("movie/{movie_id}/credits?language=en-US")
  suspend fun getMovieCredits(@Path("movie_id") movieId: Int): CreditResponse
}