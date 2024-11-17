package com.sdu.skillcinema.presentation.film_page.states

import com.sdu.skillcinema.domain.model.DetailMovie

data class FilmPageState (
    var isLoading: Boolean = false,
    var movie: DetailMovie? = null,
    var error: String = "",
    var filmId: Int? = 0
)