package com.sdu.skillcinema.domain.usecase

import com.sdu.skillcinema.data.repository.MovieRepositoryImpl

import com.sdu.skillcinema.domain.model.Actors
import com.sdu.skillcinema.domain.model.DetailMovie
import com.sdu.skillcinema.domain.model.Images
import com.sdu.skillcinema.domain.model.Movie
import com.sdu.skillcinema.domain.model.SimilarMovies
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType

class MovieUseCase {

    private val movieRepository = MovieRepositoryImpl()

    suspend fun getFilmById(id: Int): Movie {
        return movieRepository.getMovie(id)
    }

    suspend fun getFilmsByCollectionType(
        moviesCollectionType: MoviesCollectionType
    ) : List<Movie> {
        return movieRepository.getMoviesByCollection(moviesCollectionType).items
    }

    suspend fun getAllFilms() : Map<MoviesCollectionType, List<Movie>> {

        var map =  mutableMapOf<MoviesCollectionType, List<Movie>>()

        for (type in MoviesCollectionType.values()) {

            var movies = getFilmsByCollectionType(type)

            map[type] = movies

        }

        return map
    }

    suspend fun getDetailFilm(
        id: Int
    ): DetailMovie {
        return movieRepository.getMovieById(id)
    }

    suspend fun getActors(
        id: Int,
    ): List<Actors> {
        return movieRepository.getActors(id)
    }

//    suspend fun getActorsById(
//        id: Int,
//    ): Actors {
//        return movieRepository.getActorsById(id)
//    }

    suspend fun getSimilarMovies(
        id: Int,
    ): SimilarMovies {
        return movieRepository.getSimilarMovies(id)
    }

    suspend fun getImages(
        id: Int,
    ): Images {
        return movieRepository.getImages(id)
    }


}