package com.toanitdev.moviedb.presentation.modules.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.toanitdev.moviedb.domain.usecase.GetFavMoviesPaging

class FavouriteViewModel(
  val getFavMoviesPaging: GetFavMoviesPaging
) : ViewModel() {


  val favMovies = getFavMoviesPaging(Unit).cachedIn(viewModelScope)


}