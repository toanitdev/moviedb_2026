package com.toanitdev.moviedb.presentation.modules.home

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.toanitdev.moviedb.core.ApiResult
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.usecase.GetAllFavId
import com.toanitdev.moviedb.domain.usecase.GetDiscoverMoviesPaging
import com.toanitdev.moviedb.domain.usecase.SetFavMovie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class HomeViewModel(
  val getDiscoverMoviesPaging: GetDiscoverMoviesPaging,
  val setFavMovie: SetFavMovie,
  val getAllFavId: GetAllFavId
  ) : ViewModel() {

  val movies: Flow<PagingData<Movie>> =
    getDiscoverMoviesPaging(Unit).cachedIn(viewModelScope)


  private val _favState = MutableStateFlow<Set<Int>>(setOf())
  val favState: StateFlow<Set<Int>> = _favState


  fun getFavMoviesIds() {
    viewModelScope.launch {
      getAllFavId(Unit).collect {
        _favState.value = it.toSet()
      }
    }
  }

  fun updateFavMovie(movieId: Int, isFav: Boolean) {

    if (isFav) {
      _favState.value = _favState.value + movieId
    } else {
      _favState.value = _favState.value - movieId
    }

    viewModelScope.launch {
      setFavMovie(SetFavMovie.Params(movieId, isFav)).collect {
        when(it) {
          is ApiResult.Failure -> {
            if (!isFav) {
              _favState.value = _favState.value + movieId
            } else {
              _favState.value = _favState.value - movieId
            }
          }
          is ApiResult.Success<String> -> {
            if (isFav) {
              _favState.value = _favState.value + movieId
            } else {
              _favState.value = _favState.value - movieId
            }
          }
        }
      }
    }
  }
}


sealed class HomeState {
  data class Success(val movies: List<Movie>) : HomeState()
  data class Failure(val error: Throwable) : HomeState()
  object Loading : HomeState()
  object Initial : HomeState()
}