package com.toanitdev.moviedb.data.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.toanitdev.moviedb.data.remote.sevices.MovieDBService
import com.toanitdev.moviedb.domain.models.Movie

class MoviePagingSource(
  private val api: MovieDBService
) : PagingSource<Int, Movie>() {

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
    return try {
      val page = params.key ?: 1
      val response = api.getDiscoverMovies(page = page)

      LoadResult.Page(
        data = response.results,
        prevKey = if (page == 1) null else page - 1,
        nextKey = if (response.results.isEmpty()) null else page + 1
      )
    } catch (e: Exception) {
      LoadResult.Error(e)
    }
  }

  override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
    return state.anchorPosition?.let { position ->
      val page = state.closestPageToPosition(position)
      page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
    }
  }
}