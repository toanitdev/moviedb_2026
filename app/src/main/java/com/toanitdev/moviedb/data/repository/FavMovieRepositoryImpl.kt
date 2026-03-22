package com.toanitdev.moviedb.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.toanitdev.moviedb.core.ApiResult
import com.toanitdev.moviedb.data.dto.request.SetFavMovieRequest
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

  override fun setFavMovie(movieId: Int, favorite: Boolean): Flow<ApiResult<String>> {
    val request = SetFavMovieRequest(
      mediaType = "movie",
      mediaId = movieId,
      favorite = favorite
    )
    return flow {
      try{
        val data = service.setFavMovie(request)

        if(data.statusCode == 1 || data.statusCode == 12 || data.statusCode == 13) {
          emit(ApiResult.Success(data.statusMessage))
        } else {
          emit(ApiResult.Failure(Exception(data.statusMessage)))
        }
      } catch (ex: Exception) {
        emit(ApiResult.Failure(ex))
      }
    }
  }
}