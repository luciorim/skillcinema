package com.sdu.skillcinema.presentation.movie_collection

import com.sdu.skillcinema.domain.model.Movie
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType

data class MovieCollectionState (
    var isLoading: Boolean = false,
    var movies: List<Movie> = emptyList(),
    var error: String = "",
    var collectionType: MoviesCollectionType? = null
)