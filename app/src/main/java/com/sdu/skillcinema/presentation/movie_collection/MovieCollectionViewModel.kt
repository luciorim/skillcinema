package com.sdu.skillcinema.presentation.movie_collection

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType
import com.sdu.skillcinema.domain.model.enums.getMoviesCollectionTypeFromString
import com.sdu.skillcinema.domain.usecase.MovieUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MovieCollectionViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = MutableStateFlow(MovieCollectionState())
    val state: StateFlow<MovieCollectionState> = _state

    val movieUseCase = MovieUseCase()

    init {
        val typeString = savedStateHandle.get<String>("type")

        val collectionType = typeString?.let { tp ->
            getMoviesCollectionTypeFromString(tp)
        }

        if (collectionType != null) {
            getMoviesByCollection(collectionType)
        }
    }

    fun getMoviesByCollection(
        moviesCollectionType: MoviesCollectionType
    ) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)

            try {
                var movies = movieUseCase.getFilmsByCollectionType(moviesCollectionType)

                _state.value = _state.value.copy(
                    isLoading = false,
                    movies = movies,
                    collectionType = moviesCollectionType
                )

            } catch (e: HttpException) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.localizedMessage ?: "An unexpected error occurred"
                )
            }
        }
    }
}