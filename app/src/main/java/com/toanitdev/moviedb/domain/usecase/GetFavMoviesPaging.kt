package com.toanitdev.moviedb.domain.usecase

import androidx.paging.PagingData
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.repositories.FavMovieRepository
import kotlinx.coroutines.flow.Flow

class GetFavMoviesPaging(val repository: FavMovieRepository) : UseCase<PagingData<Movie>> {
  override fun invoke(): Flow<PagingData<Movie>> {
    return repository.getFavMoviesPaging()
  }
}