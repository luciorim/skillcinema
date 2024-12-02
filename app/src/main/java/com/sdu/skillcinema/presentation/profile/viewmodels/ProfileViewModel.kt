package com.sdu.skillcinema.presentation.profile.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdu.skillcinema.domain.dao.WatchedMovieDao
import com.sdu.skillcinema.presentation.profile.states.WatchedMoviesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val watchedMovieDao: WatchedMovieDao
): ViewModel() {

    private val _watchedMoviesState = MutableStateFlow(WatchedMoviesState())
    val watchedMoviesState: StateFlow<WatchedMoviesState> = _watchedMoviesState

    init {
        getWatchedMovies()
    }

    fun getWatchedMovies() {
        viewModelScope.launch {
            _watchedMoviesState.value = _watchedMoviesState.value.copy(isLoading = true)

            try {
                var movies = watchedMovieDao.getRecentVisitedMovies()

                _watchedMoviesState.value = _watchedMoviesState.value.copy(
                    isLoading = false,
                    movies = movies,
                )

            } catch (e: HttpException) {
                _watchedMoviesState.value = _watchedMoviesState.value.copy(
                    isLoading = false,
                    error = e.localizedMessage ?: "An unexpected error occurred"
                )
            }
        }
    }

    fun clearHistory() {
        viewModelScope.launch {
            watchedMovieDao.clear()
            _watchedMoviesState.value = WatchedMoviesState(isLoading = false, movies = emptyList())
        }
    }

}