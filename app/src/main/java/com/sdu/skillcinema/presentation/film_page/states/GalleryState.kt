package com.sdu.skillcinema.presentation.film_page.states

import com.sdu.skillcinema.domain.model.Images

data class GalleryState (
    var isLoading: Boolean = false,
    var gallary: Images? = null,
    var error: String = "",
    var id: Int? = 0
)