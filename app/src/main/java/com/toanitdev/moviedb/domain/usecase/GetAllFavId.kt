package com.toanitdev.moviedb.domain.usecase

import com.toanitdev.moviedb.domain.repositories.FavMovieRepository
import kotlinx.coroutines.flow.Flow

class GetAllFavId(
  val favRepository: FavMovieRepository
) : UseCase<Unit, List<Int>> {
  override fun invoke(params: Unit): Flow<List<Int>> {
    return favRepository.getFavMoviesIds()
  }
}