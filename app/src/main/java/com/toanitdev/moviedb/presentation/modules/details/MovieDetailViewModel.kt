package com.toanitdev.moviedb.presentation.modules.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toanitdev.moviedb.core.ApiResult
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.usecase.GetMovieDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel(
  val getMovieDetails: GetMovieDetails
) : ViewModel() {

  private val _movieDetailState = MutableStateFlow<MovieDetailState>(MovieDetailState.Loading)
  val movieDetailState: StateFlow<MovieDetailState> = _movieDetailState

  fun loadMovieDetails(movieId: Int) {
    _movieDetailState.value = MovieDetailState.Loading

    viewModelScope.launch {
      getMovieDetails(movieId).collect {
        when (it) {
          is ApiResult.Failure -> {
            _movieDetailState.value =
              MovieDetailState.Error(it.exception.message ?: "Unknown error")
          }

          is ApiResult.Success -> {
            _movieDetailState.value = MovieDetailState.Success(it.data)
          }
        }
      }
    }
  }

}


sealed class MovieDetailState {
  object Loading : MovieDetailState()
  data class Success(val movie: Movie) : MovieDetailState()
  data class Error(val message: String) : MovieDetailState()
}