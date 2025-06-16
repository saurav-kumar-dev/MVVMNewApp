package com.example.testapp3.movie.domain.service

import com.example.testapp3.movie.domain.model.MovieData
import com.example.testapp3.movie.domain.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("movies")
    suspend fun getMovie(): Response<MovieResponse>

}