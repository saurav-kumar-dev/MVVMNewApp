package com.example.testapp3.movie.ui

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp3.common.NetworkResult
import com.example.testapp3.movie.domain.model.MovieData
import com.example.testapp3.movie.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val useCase: MovieUseCase
) : ViewModel() {

    val isLoading = ObservableField(false)
    val isNoDataFound = ObservableField(false)
    val adapter = MovieAdapter(){
    }

    init {
        getMovieList()
    }

    private fun getMovieList() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getMovies().collect {
                when (it) {
                    is NetworkResult.Loading -> {
                        isLoading.set(true)
                    }
                    is NetworkResult.Success -> {
                        isLoading.set(false)
                        adapter.submitList(it.data)
                    }
                    is NetworkResult.Error -> {
                        isLoading.set(false)
                    }
                }
            }
        }
    }

}