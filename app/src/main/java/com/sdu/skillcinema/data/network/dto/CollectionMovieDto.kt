package com.sdu.skillcinema.data.network.dto

import com.sdu.skillcinema.domain.model.Movie

data class CollectionMovieDto(

    val total: Int,

    val totalPages: Int,

    val items: List<Movie>

)
