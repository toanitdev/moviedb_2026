package com.toanitdev.moviedb

import android.app.Application
import com.toanitdev.moviedb.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp: Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidContext(this@MyApp)
      modules(appModule)
    }
  }

}