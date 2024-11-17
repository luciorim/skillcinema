package com.sdu.skillcinema.presentation.staff_detail_movie

import com.sdu.skillcinema.domain.model.Movie

data class StaffDetailMovieState(
    var isLoading: Boolean = false,
    var staffName: String = "",
    var staffMovies: List<Movie> = emptyList(),
    var error: String = ""
)
