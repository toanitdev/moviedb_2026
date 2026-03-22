package com.toanitdev.moviedb.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.toanitdev.moviedb.core.ApiResult
import com.toanitdev.moviedb.data.remote.sevices.MovieDBService
import com.toanitdev.moviedb.data.repository.pagingSource.MoviePagingSource
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
  val movieDBService: MovieDBService
) : MovieRepository {
  override fun getDiscoverMovies(): Flow<ApiResult<List<Movie>>> {
    return flow {


      try {
        val response = movieDBService.getDiscoverMovies(1)

        if (response.results.isEmpty())
          throw Exception("No movies found")
        emit(ApiResult.Success(response.results.map { it.toMovie() }))
      } catch (ex: Exception) {
        emit(ApiResult.Failure(ex))
      }
    }
  }

  override fun getDiscoverMoviesPaging() = Pager(
    config = PagingConfig(
      pageSize = 20,
      prefetchDistance = 5,
      enablePlaceholders = false
    ),
    pagingSourceFactory = { MoviePagingSource(movieDBService) }
  ).flow

  override fun getMovieDetails(movieId: Int): Flow<ApiResult<Movie>> {
    return flow {
      try {
        val res = movieDBService.getMovieDetails(movieId).toMovie()
        emit(ApiResult.Success(data = res))
      } catch (ex: Exception) {
        emit(ApiResult.Failure(ex))
      }
    }
  }

}
