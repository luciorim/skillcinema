package com.sdu.skillcinema.presentation.film_page.states

import com.sdu.skillcinema.domain.model.Actors
import com.sdu.skillcinema.domain.model.DetailMovie

data class ActorsState(
    var isLoading: Boolean = false,
    var actor: List<Actors> = emptyList(),
    var error: String = "",
    var id: Int? = 0
)