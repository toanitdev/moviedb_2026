package com.toanitdev.moviedb.di

import com.toanitdev.moviedb.constants.API_KEY
import com.toanitdev.moviedb.constants.BASE_URL
import com.toanitdev.moviedb.data.remote.sevices.MovieDBService
import com.toanitdev.moviedb.data.repository.FavMovieRepositoryImpl
import com.toanitdev.moviedb.data.repository.MovieRepositoryImpl
import com.toanitdev.moviedb.domain.repositories.FavMovieRepository
import com.toanitdev.moviedb.domain.repositories.MovieRepository
import com.toanitdev.moviedb.domain.usecase.GetAllFavId
import com.toanitdev.moviedb.domain.usecase.GetDiscoverMoviesPaging
import com.toanitdev.moviedb.domain.usecase.GetFavMoviesPaging
import com.toanitdev.moviedb.domain.usecase.SetFavMovie
import com.toanitdev.moviedb.presentation.modules.favourite.FavouriteViewModel
import com.toanitdev.moviedb.presentation.modules.home.HomeViewModel
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

  // OkHttpClient with AuthInterceptor
  single {
    val logging = HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.BODY
    }
    okhttp3.OkHttpClient.Builder()
      .addInterceptor { chain ->
        val request = chain.request().newBuilder()
          .addHeader("Authorization", "Bearer $API_KEY")
          .addHeader("Accept", "application/json")
          .build()
        chain.proceed(request)
      }
      .addInterceptor(logging)
      .build()
  }
  // Retrofit
  single {
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .client(get())
      .build()
  }

  // API
  single<MovieDBService> {
    get<Retrofit>().create(MovieDBService::class.java)
  }

  // Repository
  single<MovieRepository> {
    MovieRepositoryImpl(get())
  }
  single<FavMovieRepository> {
    FavMovieRepositoryImpl(get())
  }

  // ViewModel
  viewModel {
    HomeViewModel(get(), get(), get())
  }
  viewModel{
    FavouriteViewModel(get())
  }
  // use cases
  single {
    GetDiscoverMoviesPaging(get(), get())
  }
  single {
    GetFavMoviesPaging(get())
  }
  single {
    SetFavMovie(get())
  }
  single {
    GetAllFavId(get())
  }

}