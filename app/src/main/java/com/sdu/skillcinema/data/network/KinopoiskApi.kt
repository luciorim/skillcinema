package com.sdu.skillcinema.data.network

import com.sdu.skillcinema.common.Constants
import com.sdu.skillcinema.data.network.dto.CollectionMovieDto
import com.sdu.skillcinema.domain.model.Actors
import com.sdu.skillcinema.domain.model.DetailMovie
import com.sdu.skillcinema.domain.model.Images
import com.sdu.skillcinema.domain.model.Movie
import com.sdu.skillcinema.domain.model.SimilarMovies
import com.sdu.skillcinema.domain.model.Staff
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface KinopoiskApi {

    @GET("/api/v2.2/films/{id}")
    @Headers("X-API-KEY: ${Constants.APIKEY}")
    suspend fun getMovie(
        @Path("id") id: Int,
    ): Movie

    @GET("/api/v2.2/films/collections")
    @Headers("X-API-KEY: ${Constants.APIKEY}")
    suspend fun getMoviesByCollection(
        @Query("type") type: MoviesCollectionType,
        @Query("page") page: Int = 1
    ): CollectionMovieDto

    @GET("/api/v2.2/films/{id}")
    @Headers("X-API-KEY: ${Constants.APIKEY}")
    suspend fun getMovieById(
        @Path("id") id: Int,
    ): DetailMovie

    @GET("/api/v1/staff")
    @Headers("X-API-KEY: ${Constants.APIKEY}")
    suspend fun getActors(
        @Query("filmId") filmId: Int,
    ): List<Actors>

    @GET("/api/v1/staff/{id}")
    @Headers("X-API-KEY: ${Constants.APIKEY}")
    suspend fun getStaffDetails(
        @Path("id") id: Int,
    ): Staff

    @GET("/api/v2.2/films/{id}/similars")
    @Headers("X-API-KEY: ${Constants.APIKEY}")
    suspend fun getSimilarMovies(
        @Path("id") id: Int,
    ): SimilarMovies

    @GET("/api/v2.2/films/{id}/images")
    @Headers("X-API-KEY: ${Constants.APIKEY}")
    suspend fun getImages(
        @Path("id") id: Int,
    ): Images

}

