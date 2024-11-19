package com.sdu.skillcinema.presentation.gallery

import com.sdu.skillcinema.domain.model.Images

data class GalleryPageState (
    var isLoading: Boolean = false,
    var gallary: Images? = null,
    var error: String = "",
    var id: Int? = 0
)