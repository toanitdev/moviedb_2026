package com.toanitdev.moviedb.domain.usecase

import kotlinx.coroutines.flow.Flow

interface UseCase<Params,T> {
  operator fun invoke(params: Params): Flow<T>
}