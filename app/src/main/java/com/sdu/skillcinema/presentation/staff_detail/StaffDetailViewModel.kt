package com.sdu.skillcinema.presentation.staff_detail

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

class StaffDetailViewModel(
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val _state = MutableStateFlow(StaffDetailState())
    val state: StateFlow<StaffDetailState> = _state

    private val staffUseCase = StaffUseCase()
    private val movieUseCase = MovieUseCase()

    init {
        val id: Int? = savedStateHandle.get<String>("staffId")?.toInt()

        if (id != null) {
            getStaffDetails(id)
        }
    }

    private fun getStaffDetails(id: Int) {
        viewModelScope.launch {

            _state.value = StaffDetailState(isLoading = true)

            try {
                var staff = staffUseCase.getStuffDetailsById(id)
                val staffMovies = mutableListOf<Movie>()

                for (film in staff.films.take(7)) {
                    var mov = movieUseCase.getFilmById(film.filmId)
                    staffMovies.add(mov)
                }

                _state.value = StaffDetailState(
                    staff = staff,
                    staffMovies = staffMovies,
                )

            } catch (e: HttpException) {
                _state.value = StaffDetailState(error = e.message())
            }
        }
    }
}