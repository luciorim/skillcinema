package com.sdu.skillcinema.di

import com.sdu.skillcinema.data.network.KinopoiskApi
import com.sdu.skillcinema.data.repository.MovieRepositoryImpl
import com.sdu.skillcinema.data.repository.StaffRepositoryImpl
import com.sdu.skillcinema.domain.repository.MovieRepository
import com.sdu.skillcinema.domain.repository.StaffRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.security.spec.RSAOtherPrimeInfo
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesMovieRepository(
        api: KinopoiskApi
    ): MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesStaffRepository(
        api: KinopoiskApi
    ): StaffRepository {
        return StaffRepositoryImpl(api)
    }


}