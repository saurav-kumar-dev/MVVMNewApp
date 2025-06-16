package com.example.testapp3.movie.domain.usecase

import com.example.testapp3.common.NetworkResult
import com.example.testapp3.movie.domain.model.MovieResponse
import com.example.testapp3.movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val movieRepository: MovieRepository){

    fun getMovies(): Flow<NetworkResult<MovieResponse>>  = flow{
        try {
            emit(NetworkResult.Loading())
            val response = movieRepository.getMovieList()
            if (response.isSuccessful){
                emit(NetworkResult.Success(data = response.body()))
            }else{
               emit(NetworkResult.Error(errorMessage = response.errorBody().toString()))
            }
        }catch (e: HttpException){
            emit(NetworkResult.Error(e.localizedMessage?:"Something went wrong"))
        }catch (e: IOException){
            emit(NetworkResult.Error(e.localizedMessage?:"Something went wrong"))
        }catch (e: Exception){
            emit(NetworkResult.Error(e.localizedMessage?:"Something went wrong"))
        }
    }

}