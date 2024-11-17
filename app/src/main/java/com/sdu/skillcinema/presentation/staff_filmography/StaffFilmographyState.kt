package com.sdu.skillcinema.presentation.staff_filmography

import com.sdu.skillcinema.domain.model.Movie
import com.sdu.skillcinema.domain.model.enums.ProfessionKey

data class StaffFilmographyState(
    var isLoading: Boolean = false,
    var movies: Map<ProfessionKey, List<Movie>> = emptyMap(),
    var staffName: String = "",
    var error: String = "",
    var professionKey: ProfessionKey = ProfessionKey.ACTOR
)