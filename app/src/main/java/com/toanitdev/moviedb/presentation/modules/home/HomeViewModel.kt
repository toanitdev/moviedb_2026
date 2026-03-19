package com.toanitdev.moviedb.presentation.modules.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.usecase.GetDiscoverMoviesPaging
import kotlinx.coroutines.flow.Flow

class HomeViewModel(val getDiscoverMoviesPaging: GetDiscoverMoviesPaging) : ViewModel() {

  val movies: Flow<PagingData<Movie>> =
    getDiscoverMoviesPaging().cachedIn(viewModelScope)

}


sealed class HomeState {
  data class Success(val movies: List<Movie>) : HomeState()
  data class Failure(val error: Throwable) : HomeState()
  object Loading : HomeState()
  object Initial : HomeState()
}