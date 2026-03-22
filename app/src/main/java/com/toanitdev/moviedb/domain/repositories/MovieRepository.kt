package com.toanitdev.moviedb.domain.repositories

import androidx.paging.PagingData
import com.toanitdev.moviedb.core.ApiResult
import com.toanitdev.moviedb.data.dto.response.ListResponse
import com.toanitdev.moviedb.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

  fun getDiscoverMovies() : Flow<ApiResult<List<Movie>>>
  fun getDiscoverMoviesPaging() : Flow<PagingData<Movie>>
  fun getMovieDetails(movieId: Int) : Flow<ApiResult<Movie>>
}