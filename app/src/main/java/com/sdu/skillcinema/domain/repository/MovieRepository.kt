package com.sdu.skillcinema.domain.repository

import com.sdu.skillcinema.data.network.dto.CollectionMovieDto
import com.sdu.skillcinema.domain.model.Movie

import com.sdu.skillcinema.domain.model.Actors
import com.sdu.skillcinema.domain.model.DetailMovie
import com.sdu.skillcinema.domain.model.Images
import com.sdu.skillcinema.domain.model.SimilarMovies
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType

interface MovieRepository {

    suspend fun getMovie(id: Int): Movie

    suspend fun getMoviesByCollection(type: MoviesCollectionType): CollectionMovieDto
    suspend fun getMovieById(id: Int): DetailMovie
    suspend fun getActors(filmId: Int): List<Actors>
//    suspend fun getActorsById(id: Int): Actors
    suspend fun getSimilarMovies(id: Int): SimilarMovies
    suspend fun getImages(id: Int): Images


}