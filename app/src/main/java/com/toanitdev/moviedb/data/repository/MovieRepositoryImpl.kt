package com.toanitdev.moviedb.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.toanitdev.moviedb.core.ApiResult
import com.toanitdev.moviedb.data.mapper.toDomain
import com.toanitdev.moviedb.data.remote.sevices.MovieDBService
import com.toanitdev.moviedb.data.repository.pagingSource.MoviePagingSource
import com.toanitdev.moviedb.domain.models.Cast
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.models.Poster
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
        emit(ApiResult.Success(response.results.map { it.toDomain() }))
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
        val res = movieDBService.getMovieDetails(movieId).toDomain()
        val posters = movieDBService.getMovieImages(movieId).posters.map { Poster(
          filePath = it.filePath,
          width = it.width,
          height = it.height
        ) }

        val casts = movieDBService.getMovieCredits(movieId).cast.map { cast ->

          Cast(
            id = cast.id,
            name = cast.name,
            character = cast.character,
            profilePath = cast.profile_path
          )

        }
        res.posters = posters
        res.casts = casts
        emit(ApiResult.Success(data = res))
      } catch (ex: Exception) {
        emit(ApiResult.Failure(ex))
      }
    }
  }

  override fun getMoviePosters(movieId: Int): Flow<ApiResult<List<Poster>>> {
    return flow {
      try {
        val posters = movieDBService.getMovieImages(movieId).posters.map { Poster(
          filePath = it.filePath,
          width = it.width,
          height = it.height
        ) }
        emit(ApiResult.Success(data = posters))
      } catch (ex: Exception) {
        emit(ApiResult.Failure(ex))
      }
    }

  }

}
