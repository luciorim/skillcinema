package com.sdu.skillcinema.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.sdu.skillcinema.domain.model.Movie

@Composable
fun FilmographyMovie(
    movie: Movie
) {

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 26.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier.clickable { /*TODO*/ }
        ){
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .width(86.dp)
                    .height(132.dp),
                contentDescription = null,
                model = movie.posterUrl
            )
            Text(
                text = movie.ratingKinopoisk.toString(),
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(4.dp)
                    .background(Color(0xFF3D3BFF), shape = RoundedCornerShape(6.dp))
                    .padding(horizontal = 6.dp),
                color = Color.White
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 50.dp, bottom = 50.dp)
        ) {
            Text(
                text = movie.nameRu,
                style = TextStyle(
                    fontWeight = FontWeight.W600,
                    fontSize = 14.sp,
                    lineHeight = 15.4.sp
                )
            )
            var movieGenre: String = ""
            movie.genres.forEachIndexed { idx, gnr ->
                if(idx == 0) {
                    movieGenre += gnr.genre
                } else {
                    movieGenre += ", ${gnr.genre}"
                }
            }

            Text(
                text = "${movie.year}, ${movieGenre}",
                style = TextStyle(
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp,
                    lineHeight = 13.2.sp,
                    color = Color(0xff838390)
                )
            )
        }
    }
}