package com.toanitdev.moviedb.presentation.modules.favourite

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.toanitdev.moviedb.domain.models.Movie
import com.toanitdev.moviedb.moviesJson

class FavouriteViewModel: ViewModel() {


  val favMovies = Gson().fromJson(moviesJson, Array<Movie>::class.java).toList()



}