package com.sdu.skillcinema.domain.repository

import com.sdu.skillcinema.data.network.dto.CollectionMovieDto
import com.sdu.skillcinema.domain.model.Movie
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType

interface MovieRepository {

    suspend fun getMovieById(id: Int): Movie

    suspend fun getMoviesByCollection(type: MoviesCollectionType): CollectionMovieDto

}