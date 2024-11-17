package com.sdu.skillcinema.data.repository

import com.sdu.skillcinema.data.network.KinopoiskApi
import com.sdu.skillcinema.data.network.dto.CollectionMovieDto
import com.sdu.skillcinema.data.network.retrofit
import com.sdu.skillcinema.domain.model.Movie
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType
import com.sdu.skillcinema.domain.repository.MovieRepository


class MovieRepositoryImpl : MovieRepository {

    private val api = retrofit.create(KinopoiskApi::class.java)

    override suspend fun getMovie(id: Int): Movie {
        return api.getMovie(id)
    }

    override suspend fun getMoviesByCollection(
        type: MoviesCollectionType,
    ): CollectionMovieDto {
        return api.getMoviesByCollection(type)
    }




}