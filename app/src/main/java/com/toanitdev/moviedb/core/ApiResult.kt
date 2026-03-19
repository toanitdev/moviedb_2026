package com.toanitdev.moviedb.core

sealed class ApiResult<out T> {
  data class Success<out T>(val data: T) : ApiResult<T>()
  data class Failure(val exception: Throwable) : ApiResult<Nothing>()
}