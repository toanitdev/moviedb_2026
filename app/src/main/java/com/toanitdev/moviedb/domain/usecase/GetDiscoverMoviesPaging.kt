package com.toanitdev.moviedb.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.repositories.FavMovieRepository
import com.toanitdev.moviedb.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class GetDiscoverMoviesPaging(
  val repository: MovieRepository,
  val favRepository: FavMovieRepository
) : UseCase<PagingData<Movie>> {
  override fun invoke(): Flow<PagingData<Movie>> {
    return combine(repository.getDiscoverMoviesPaging(), favRepository.getFavMoviesIds()) { pagingData, favIds ->
      pagingData.map { movie ->
        if (favIds.contains(movie.id)) {
          movie.copy(isFav = true)
        } else {
          movie
        }
      }
    }
  }
}