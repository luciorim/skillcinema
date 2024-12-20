package com.sdu.skillcinema.presentation.profile.states

import com.sdu.skillcinema.data.entities.WatchedMovie

data class WatchedMoviesState(
    var isLoading: Boolean = false,
    var movies: List<WatchedMovie> = emptyList(),
    var error: String = "",
)
