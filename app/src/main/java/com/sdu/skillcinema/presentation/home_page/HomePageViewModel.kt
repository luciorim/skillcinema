package com.sdu.skillcinema.presentation.home_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdu.skillcinema.domain.usecase.MovieUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class HomePageViewModel : ViewModel() {

    private val _state =  MutableStateFlow<HomePageState>(HomePageState())
    val state: StateFlow<HomePageState> = _state

    private val movieUseCase = MovieUseCase()

    init {
        getAllMovies()
    }

    private fun getAllMovies() {

        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)

            try {
                var movies = movieUseCase.getAllFilms()
                _state.value = _state.value.copy(isLoading = false, movies = movies)

            } catch (e: HttpException) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.localizedMessage ?: "An unexpected error occurred"
                )
            }
        }
    }


}