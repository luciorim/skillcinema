package com.sdu.skillcinema.data.models

import androidx.compose.runtime.Stable
import com.sdu.skillcinema.R

@Stable
data class CinemaList(
    val title: String,
    val list: List<CinemaListItem>
)

@Stable
data class CinemaListItem(
    val title: String,
    val genre: String,
    val rating: Double,
    val imageId: Int = R.drawable.img,
)