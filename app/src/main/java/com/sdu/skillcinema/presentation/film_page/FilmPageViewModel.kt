package com.sdu.skillcinema.presentation.film_page


import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdu.skillcinema.domain.usecase.MovieUseCase
import com.sdu.skillcinema.presentation.film_page.states.ActorsState
import com.sdu.skillcinema.presentation.film_page.states.FilmPageState
import com.sdu.skillcinema.presentation.film_page.states.GalleryState
import com.sdu.skillcinema.presentation.film_page.states.SimilarFilmState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class FilmPageViewModel(savedStateHandle: SavedStateHandle): ViewModel() {
    private val _stateMovie =  MutableStateFlow<FilmPageState>(FilmPageState())
    val stateMovie: StateFlow<FilmPageState> = _stateMovie
    private val _stateActors =  MutableStateFlow<ActorsState>(ActorsState())
    val stateActors: StateFlow<ActorsState> = _stateActors
    private val _stateGallery =  MutableStateFlow<GalleryState>(GalleryState())
    val stateGallery: StateFlow<GalleryState> = _stateGallery
    private val _stateSimilarFilm =  MutableStateFlow<SimilarFilmState>(SimilarFilmState())
    val stateSimilarFilm: StateFlow<SimilarFilmState> = _stateSimilarFilm

    private val movieUseCase = MovieUseCase()

    init {
        val id = savedStateHandle.get<Int>("id")
        Log.d("id", id.toString())


        if (id != null) {
            getMovieById(id)
            getActors(id)
            getGallery(id)
            getSimilarMovies(id)
        }
    }

    fun getMovieById(id: Int){

        viewModelScope.launch {
            _stateMovie.value = _stateMovie.value.copy(isLoading = true)

            try {
                var movie = movieUseCase.getDetailFilm(id)

                _stateMovie.value = _stateMovie.value.copy(
                    isLoading = false,
                    movie = movie
                )
            } catch (e: HttpException) {
                _stateMovie.value = _stateMovie.value.copy(
                    isLoading = false,
                    error = e.localizedMessage ?: "An unexpected error occurred"
                )
            }
        }
    }

    fun getActors(id: Int){
        viewModelScope.launch {
            _stateActors.value = _stateActors.value.copy(isLoading = true)

            try {
                var actors = movieUseCase.getActors(id)

                _stateActors.value = _stateActors.value.copy(
                    isLoading = false,
                    actor = actors
                )
            } catch (e: HttpException) {
                _stateActors.value = _stateActors.value.copy(
                    isLoading = false,
                    error = e.localizedMessage ?: "An unexpected error occurred"
                )
            }
        }
    }

    fun getGallery(id: Int){
        viewModelScope.launch {
            _stateGallery.value = _stateGallery.value.copy(isLoading = true)

            try {
                var gallery = movieUseCase.getImages(id)

                _stateGallery.value = _stateGallery.value.copy(
                    isLoading = false,
                    gallary = gallery
                )
            } catch (e: HttpException) {
                _stateGallery.value = _stateGallery.value.copy(
                    isLoading = false,
                    error = e.localizedMessage ?: "An unexpected error occurred"
                )
            }
        }
    }

    fun getSimilarMovies(id: Int){
        viewModelScope.launch {
            _stateSimilarFilm.value = _stateSimilarFilm.value.copy(isLoading = true)

            try {
                var movie = movieUseCase.getSimilarMovies(id)

                _stateSimilarFilm.value = _stateSimilarFilm.value.copy(
                    isLoading = false,
                    movies = movie
                )
            } catch (e: HttpException) {
                _stateSimilarFilm.value = _stateSimilarFilm.value.copy(
                    isLoading = false,
                    error = e.localizedMessage ?: "An unexpected error occurred"
                )
            }
        }
    }
}