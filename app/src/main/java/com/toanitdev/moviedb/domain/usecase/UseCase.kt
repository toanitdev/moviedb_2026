package com.toanitdev.moviedb.domain.usecase

import kotlinx.coroutines.flow.Flow

interface UseCase<T> {
  operator fun invoke(): Flow<T>
}