package com.toanitdev.moviedb.domain.repositories

import androidx.paging.PagingData
import com.toanitdev.moviedb.core.ApiResult
import com.toanitdev.moviedb.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface FavMovieRepository {

  fun getFavMoviesIds() : Flow<List<Int>>
  fun getFavMoviesPaging() : Flow<PagingData<Movie>>

  fun setFavMovie(movieId: Int, favorite: Boolean) : Flow<ApiResult<String>>
}