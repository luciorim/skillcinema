package com.sdu.skillcinema.data.network

import com.sdu.skillcinema.common.Constants
import com.sdu.skillcinema.data.network.dto.CollectionMovieDto
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface KinopoiskApi {

    @GET("/api/v2.2/films/collections")
    @Headers("X-API-KEY", Constants.APIKEY)
    suspend fun getMoviesByCollection(
        @Query("type") type: MoviesCollectionType
    ): CollectionMovieDto

}