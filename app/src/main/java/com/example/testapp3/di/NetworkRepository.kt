package com.example.testapp3.di

import com.example.testapp3.movie.domain.repository.MovieDataRepository
import com.example.testapp3.movie.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkRepository {

    @Binds
    abstract fun bindRepository(movieDataRepository: MovieDataRepository): MovieRepository

}