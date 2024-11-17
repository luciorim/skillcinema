package com.sdu.skillcinema.domain.usecase

import com.sdu.skillcinema.data.repository.MovieRepositoryImpl
import com.sdu.skillcinema.domain.model.Movie
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType

class MovieUseCase {

    private val movieRepository = MovieRepositoryImpl()

    suspend fun getFilmById(id: Int): Movie {
        return movieRepository.getMovieById(id)
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


}