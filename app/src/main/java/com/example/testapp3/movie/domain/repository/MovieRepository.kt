package com.example.testapp3.movie.domain.repository

import com.example.testapp3.movie.domain.model.MovieResponse
import retrofit2.Response

interface MovieRepository {

    suspend fun getMovieList(): Response<MovieResponse>

}