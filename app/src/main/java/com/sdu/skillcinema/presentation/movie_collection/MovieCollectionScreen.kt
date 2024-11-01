package com.sdu.skillcinema.presentation.movie_collection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.sdu.skillcinema.R
import com.sdu.skillcinema.presentation.components.MovieItem

@Composable
fun MovieCollectionScreen(
//    navController: NavController,
    movieCollectionViewModel: MovieCollectionViewModel = viewModel()
) {

    val state = movieCollectionViewModel.state.value

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon ( //todo: mb change to button to return to previous page
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back icon",
                    modifier = Modifier
                        .padding(
                            vertical = 16.dp,
                            horizontal = 26.dp
                        )
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = "Temporary", //todo: put collection type here
                    style = TextStyle(
                        fontWeight = FontWeight.W600,
                        fontSize = 12.sp,
                        lineHeight = 13.2.sp,
                        color = Color(0xFF272727)
                    )
                )
            }
            //todo: check layout after connect api
            LazyVerticalGrid (
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(
                        start = 61.dp,
                        end = 61.dp
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.movies) { movie ->
                    MovieItem(
                        movie = movie,
                        onItemClick = {
                            //todo open movie detail page (later)
                        }
                    )
                }
            }

        }
    }
}
