package com.sdu.skillcinema.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.sdu.skillcinema.R
import com.sdu.skillcinema.domain.model.Movie

//todo: its just a copy of CinemaListItemModel
@Composable
fun MovieItem(
    movie: Movie,
    onItemClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .width(111.dp)
            .height(194.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(22.dp)
            ),
    ){
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Box (
                modifier = Modifier
                    .clickable { onItemClick() }
            ) {
                AsyncImage(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .width(111.dp)
                        .height(156.dp),
                    model = movie.posterUrl,
                    placeholder = painterResource(id = R.drawable.img),
                    error = painterResource(id = R.drawable.img),
                    contentDescription = "Movie poster",
                )

                Text(
                    text = movie.ratingKinopoisk.toString(),
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                        .background(Color(0xFF3D3BFF), shape = RoundedCornerShape(6.dp))
                        .padding(horizontal = 6.dp),
                    color = Color.White
                )
            }

            Text(
                modifier = Modifier
                    .padding(top = 2.dp)
                    .widthIn(max = 108.dp),
                text = movie.nameRu,
                style = TextStyle(
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp,
                    color = Color.Black
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = movie.genres.get(0).genre,
                style = TextStyle(
                    fontSize = 10.sp,
                    color = Color.Gray
                )
            )
        }
    }
}

