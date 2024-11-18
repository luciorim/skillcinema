package com.sdu.skillcinema.presentation.staff_detail

import com.sdu.skillcinema.domain.model.Movie
import com.sdu.skillcinema.domain.model.Staff

data class StaffDetailState (
    var isLoading: Boolean = false,
    var staff: Staff? = null,
    var staffMovies: List<Movie> = emptyList(),
    var error: String = "",
)