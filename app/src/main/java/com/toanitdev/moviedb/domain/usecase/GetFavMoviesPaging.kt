package com.toanitdev.moviedb.domain.usecase

import androidx.paging.PagingData
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.repositories.FavMovieRepository
import kotlinx.coroutines.flow.Flow

class GetFavMoviesPaging(val repository: FavMovieRepository) : UseCase<Unit, PagingData<Movie>> {
  override fun invoke(params: Unit): Flow<PagingData<Movie>> {
    return repository.getFavMoviesPaging()
  }
}