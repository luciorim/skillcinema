package com.sdu.skillcinema.di

import com.sdu.skillcinema.common.Constants
import com.sdu.skillcinema.data.network.KinopoiskApi
import com.sdu.skillcinema.data.repository.MovieRepositoryImpl
import com.sdu.skillcinema.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideKinopoiskClient(): KinopoiskApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KinopoiskApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: KinopoiskApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }

}