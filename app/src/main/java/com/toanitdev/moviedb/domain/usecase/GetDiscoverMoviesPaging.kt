package com.toanitdev.moviedb.domain.usecase

import androidx.paging.PagingData
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetDiscoverMoviesPaging(
  val repository: MovieRepository
) : UseCase<PagingData<Movie>> {
  override fun invoke(): Flow<PagingData<Movie>>  =
    repository.getDiscoverMoviesPaging()
}