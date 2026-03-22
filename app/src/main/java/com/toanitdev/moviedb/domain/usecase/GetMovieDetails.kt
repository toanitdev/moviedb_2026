package com.toanitdev.moviedb.domain.usecase

import com.toanitdev.moviedb.core.ApiResult
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieDetails(val movieRepository: MovieRepository): UseCase<Int, ApiResult<Movie>> {
  override fun invoke(params: Int): Flow<ApiResult<Movie>> {
    return movieRepository.getMovieDetails(params)
  }
}