package com.sdu.skillcinema.presentation.home_page

import com.sdu.skillcinema.domain.model.Movie
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType

data class HomePageState (
    var isLoading: Boolean = false,
    var movies: Map<MoviesCollectionType, List<Movie>> = emptyMap(),
    var error: String = "",
)