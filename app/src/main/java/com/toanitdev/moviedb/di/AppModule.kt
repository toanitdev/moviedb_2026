package com.toanitdev.moviedb.di

import com.toanitdev.moviedb.constants.API_KEY
import com.toanitdev.moviedb.constants.BASE_URL
import com.toanitdev.moviedb.data.remote.sevices.MovieDBService
import com.toanitdev.moviedb.data.repository.MovieRepositoryImpl
import com.toanitdev.moviedb.domain.repositories.MovieRepository
import com.toanitdev.moviedb.presentation.modules.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    // OkHttpClient with AuthInterceptor
    single {
            okhttp3.OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $API_KEY")
                    .addHeader("Accept", "application/json")
                    .build()
                chain.proceed(request)
            }
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

    // ViewModel
    viewModel {
        HomeViewModel(get())
    }
}