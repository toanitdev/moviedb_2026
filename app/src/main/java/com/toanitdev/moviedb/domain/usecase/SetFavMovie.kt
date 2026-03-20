package com.toanitdev.moviedb.domain.usecase

import com.toanitdev.moviedb.core.ApiResult
import com.toanitdev.moviedb.domain.repositories.FavMovieRepository
import kotlinx.coroutines.flow.Flow

class SetFavMovie(val repository: FavMovieRepository) : UseCase<SetFavMovie.Params, ApiResult<String>> {
  override fun invoke(params: Params): Flow<ApiResult<String>> {
    return repository.setFavMovie(params.movieId, params.favorite)
  }
  data class Params(val movieId: Int, val favorite: Boolean)
}