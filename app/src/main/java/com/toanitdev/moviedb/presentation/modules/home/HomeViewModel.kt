package com.toanitdev.moviedb.presentation.modules.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toanitdev.moviedb.core.ApiResult
import com.toanitdev.moviedb.data.repository.MovieRepositoryImpl
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(val repository: MovieRepository) : ViewModel() {


  private var homeState = MutableStateFlow<HomeState>(HomeState.Initial)
  val homeStateFlow: StateFlow<HomeState> = homeState




  fun fetchDiscoverMovies() {
    homeState.value = HomeState.Loading
    viewModelScope.launch {
      repository.getDiscoverMovies().collect { result ->
        when (result) {
          is ApiResult.Success<List<Movie>> ->
            homeState.value = HomeState.Success(result.data)
          is ApiResult.Failure ->
            homeState.value = HomeState.Failure(result.exception)
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