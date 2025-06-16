package com.example.testapp3.movie.domain.repository

import com.example.testapp3.movie.domain.model.MovieResponse
import com.example.testapp3.movie.domain.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class MovieDataRepository @Inject constructor(
    private  val apiService: ApiService
): MovieRepository {

    override suspend fun getMovieList(): Response<MovieResponse> {
        return apiService.getMovie()
    }
}