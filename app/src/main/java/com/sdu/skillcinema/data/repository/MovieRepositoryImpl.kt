package com.sdu.skillcinema.data.repository

import com.sdu.skillcinema.data.network.KinopoiskApi
import com.sdu.skillcinema.data.network.dto.CollectionMovieDto
import com.sdu.skillcinema.data.network.retrofit
import com.sdu.skillcinema.domain.model.Movie

import com.sdu.skillcinema.domain.model.Actors
import com.sdu.skillcinema.domain.model.DetailMovie
import com.sdu.skillcinema.domain.model.Images
import com.sdu.skillcinema.domain.model.SimilarMovies
import com.sdu.skillcinema.domain.model.enums.ImagesType
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

    override suspend fun getMovieById(
        id: Int,
    ): DetailMovie {
        return api.getMovieById(id)
    }

    override suspend fun getActors(
        filmId: Int,
    ): List<Actors> {
        return api.getActors(filmId)
    }

//    override suspend fun getActorsById(
//        id: Int,
//    ): Actors {
//        return api.getActorsById(id)
//    }

    override suspend fun getSimilarMovies(
        id: Int,
    ): SimilarMovies {
        return api.getSimilarMovies(id)
    }

    override suspend fun getImages(
        id: Int,
    ): Images {
        return api.getImages(id)
    }




}