package com.toanitdev.moviedb.presentation.modules.favourite

import androidx.compose.runtime.mutableStateSetOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.toanitdev.moviedb.core.ApiResult
import com.toanitdev.moviedb.domain.usecase.GetFavMoviesPaging
import com.toanitdev.moviedb.domain.usecase.SetFavMovie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class FavouriteViewModel(
  val getFavMoviesPaging: GetFavMoviesPaging,
  val setFavMovie: SetFavMovie
) : ViewModel() {


  val favMovies = getFavMoviesPaging(Unit).cachedIn(viewModelScope)
  var favRemovedIds = MutableStateFlow<Set<Int>>(setOf())



  fun initLoadFavMovies() {
    favRemovedIds.value = setOf()
  }

  fun removeFavMovie(movieId: Int) {
    viewModelScope.launch {
      setFavMovie(SetFavMovie.Params(movieId, false)).collect {
        when (it) {
          is ApiResult.Failure -> {
            // do nothing
          }

          is ApiResult.Success<String> -> {
            favRemovedIds.value = favRemovedIds.value + movieId
          }
        }
      }
    }
  }
}