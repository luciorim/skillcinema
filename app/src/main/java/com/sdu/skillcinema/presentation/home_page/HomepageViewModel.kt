package com.sdu.skillcinema.presentation.movie_collection

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdu.skillcinema.common.RequestParams
import com.sdu.skillcinema.common.Resource
import com.sdu.skillcinema.domain.model.enums.MoviesCollectionType
import com.sdu.skillcinema.domain.usecase.GetMovieCollectionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor (
    private val getMovieCollectionUseCase: GetMovieCollectionUseCase,
) : ViewModel() {

    private val _state = mutableStateOf<HomepageState>(HomepageState())
    val state: State<HomepageState> = _state

    init {

        getMovieCollection(type = MoviesCollectionType.TOP_250_MOVIES)

    }

    private fun getMovieCollection (
        type: MoviesCollectionType
    ) {
        getMovieCollectionUseCase(type).onEach { result ->
            when (result) {

                is Resource.Success -> {
                    _state.value = HomepageState(movies = result.data ?: emptyList())
                }

                is Resource.Loading -> {
                    _state.value = HomepageState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = HomepageState(
                        error = result.message ?: "An unexpected error occured "
                    )
                }

            }
        }.launchIn(viewModelScope)
    }

}