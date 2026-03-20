package com.toanitdev.moviedb.presentation.modules.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.google.gson.Gson
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.domain.usecase.GetFavMoviesPaging
import com.toanitdev.moviedb.moviesJson

class FavouriteViewModel(
  val getFavMoviesPaging: GetFavMoviesPaging
): ViewModel() {


  val favMovies = getFavMoviesPaging().cachedIn(viewModelScope)



}