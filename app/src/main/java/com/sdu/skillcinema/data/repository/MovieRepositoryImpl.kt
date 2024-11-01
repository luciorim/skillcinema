package com.sdu.skillcinema.data.repository

import com.sdu.skillcinema.data.network.KinopoiskApi
import com.sdu.skillcinema.data.network.dto.CollectionMovieDto
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType
import com.sdu.skillcinema.domain.repository.MovieRepository
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor (
    private val movieApi: KinopoiskApi
) : MovieRepository {

    override suspend fun getMoviesByCollection(
        type: MoviesCollectionType,
//        page: Int
    ): CollectionMovieDto {
        return movieApi.getMoviesByCollection(type)
    }


}