package com.sdu.skillcinema.domain.usecase

import com.sdu.skillcinema.common.Resource
import com.sdu.skillcinema.domain.model.Movie
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType
import com.sdu.skillcinema.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMovieCollectionUseCase @Inject constructor(
    private val repository: MovieRepository
){
    operator fun invoke(
        type: MoviesCollectionType,
    ): Flow<Resource<List<Movie>>> = flow {

        try {

            emit(Resource.Loading())

            val movies = repository.getMoviesByCollection(type).items

            emit(Resource.Success(movies))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}