package com.sdu.skillcinema.presentation.staff_detail_movie

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdu.skillcinema.domain.model.Movie
import com.sdu.skillcinema.domain.usecase.MovieUseCase
import com.sdu.skillcinema.domain.usecase.StaffUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class StaffDetailMovieViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = MutableStateFlow(StaffDetailMovieState())
    val state: StateFlow<StaffDetailMovieState> = _state

    private val staffUseCase = StaffUseCase()
    private val movieUseCase = MovieUseCase()

    init {
        val id: Int? = savedStateHandle.get<String>("staffId")?.toInt()

        if (id != null) {
            getStaffMovies(id)
        }
    }

    private fun getStaffMovies(id: Int) {
        viewModelScope.launch {
            _state.value = StaffDetailMovieState(isLoading = true)

            try {
                var staff = staffUseCase.getStuffDetailsById(id)
                val staffMovies = mutableListOf<Movie>()

                for (film in staff.films) {
                    var mov = movieUseCase.getFilmById(film.filmId)
                    staffMovies.add(mov)
                }

                _state.value = StaffDetailMovieState(
                    staffName = staff.nameRu,
                    staffMovies = staffMovies
                )

            } catch (e: HttpException) {
                _state.value = StaffDetailMovieState(error = e.message())
            }
        }

    }
}