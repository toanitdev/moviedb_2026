package com.toanitdev.moviedb.domain.repositories

import com.toanitdev.moviedb.core.ApiResult
import com.toanitdev.moviedb.domain.models.ListResponse
import com.toanitdev.moviedb.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

  suspend fun getDiscoverMovies() : Flow<ApiResult<List<Movie>>>
}