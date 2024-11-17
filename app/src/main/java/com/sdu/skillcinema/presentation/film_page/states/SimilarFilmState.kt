package com.sdu.skillcinema.presentation.film_page.states

import com.sdu.skillcinema.domain.model.SimilarMovies

data class SimilarFilmState (
    var isLoading: Boolean = false,
    var movies: SimilarMovies? = null,
    var error: String = "",
    var id: Int? = 0
)