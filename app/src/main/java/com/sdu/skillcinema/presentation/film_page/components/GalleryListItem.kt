package com.sdu.skillcinema.presentation.film_page.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.sdu.skillcinema.domain.model.DetailMovie
import com.sdu.skillcinema.domain.model.Image
import com.sdu.skillcinema.domain.model.Images
import com.sdu.skillcinema.domain.model.Movie


@Composable
fun GalleryListItem(images: List<Image>, navController: NavController, film: DetailMovie) {
    if (images.isNotEmpty()) {
        Column(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            HeaderItem("Галерея", images, {navController.navigate("galleryPage/${film.kinopoiskId}")})
            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                items(images) { image ->
                    AsyncImage(
                        model = image.imageUrl,
                        contentDescription = "",
                        modifier = Modifier
                            .height(400.dp)
                            .width(200.dp)
                    )
                }
            }
        }
    }
}