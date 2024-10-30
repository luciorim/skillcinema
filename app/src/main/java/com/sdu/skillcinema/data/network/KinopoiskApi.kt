package com.sdu.skillcinema.data.network

import com.sdu.skillcinema.BuildConfig
import com.sdu.skillcinema.data.network.dto.CollectionMovieDto
import com.sdu.skillcinema.domain.model.Movie
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface KinopoiskApi {

    @GET("/api/v2.2/films/collections")
    @Headers("X-API-KEY: ${BuildConfig.KINOPOISK_APIKEY}")
    suspend fun getMoviesByCollection(
        @Query("page") page: Int,
        @Query("type") type: MoviesCollectionType
    ): CollectionMovieDto

}