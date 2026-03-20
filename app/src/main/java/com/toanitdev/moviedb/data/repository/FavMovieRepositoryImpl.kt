package com.toanitdev.moviedb.data.repository

import android.app.Service
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.toanitdev.moviedb.data.remote.sevices.MovieDBService
import com.toanitdev.moviedb.data.repository.pagingSource.FavMoviePagingSource
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.repositories.FavMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FavMovieRepositoryImpl(val service: MovieDBService) : FavMovieRepository {
  override fun getFavMoviesIds(): Flow<List<Int>> {
    return flow {
      var page = 1

      val data = service.getFavMovies(page)
      var totalPages = data.totalPages


      if(totalPages == 1) {
        emit(data.results.map { it.id })
      } else {
        var ids = data.results.map { it.id }

        while(page < totalPages) {
          page += 1
          val data = service.getFavMovies(page)
          ids = ids + data.results.map { it.id }
        }

        emit(ids)
      }

    }
  }

  override fun getFavMoviesPaging(): Flow<PagingData<Movie>> = Pager(
    config = PagingConfig(
      pageSize = 20,
      prefetchDistance = 5,
      enablePlaceholders = false
    ),
    pagingSourceFactory = { return@Pager FavMoviePagingSource(service) }
  ).flow
}