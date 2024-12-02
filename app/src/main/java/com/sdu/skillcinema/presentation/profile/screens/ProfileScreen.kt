package com.sdu.skillcinema.presentation.profile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sdu.skillcinema.R
import com.sdu.skillcinema.presentation.profile.viewmodels.ProfileViewModel
import com.sdu.skillcinema.presentation.profile.components.DeleteItem
import com.sdu.skillcinema.presentation.profile.components.WatchedMovieItem

@Composable
fun ProfileScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    val watchedFilmsState by profileViewModel.watchedMoviesState.collectAsState()

    LaunchedEffect(Unit) {
       profileViewModel.getWatchedMovies()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 26.dp)
        ) {
            if (!watchedFilmsState.isLoading && watchedFilmsState.error.isBlank()) {
                Row(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                        .padding(end = 24.dp),

                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    Text(
                        text = "Просмотрено",
                        style = TextStyle(
                            fontWeight = FontWeight.W600,
                            fontSize = 18.sp,
                            lineHeight = 19.8.sp

                        ),
                    )
                    TextButton(
                        onClick = {
                            navController.navigate("watchedMovies")
                        }
                    ) {
                        Text(
                            text = watchedFilmsState.movies.size.toString(),
                            style = TextStyle(fontSize = 15.sp),
                            color = Color(0xFF3D3BFF),
                        )
                        Icon(
                            painter = painterResource(R.drawable.ic_right),
                            contentDescription = null,
                            tint = Color(0xFF3D3BFF),
                            modifier = Modifier
                                .size(10.dp)
                                .padding(start = 4.dp)
                        )
                    }
                }
                if (watchedFilmsState.movies.size > 0) {
                    LazyRow (
                        modifier = Modifier.padding(bottom = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(9.dp)
                    ) {
                        items(watchedFilmsState.movies) { mov ->
                            WatchedMovieItem(
                                movie = mov,
                                onItemClick = { navController.navigate("detailMovie/${mov.movieId}") }
                            )
                        }
                        item {
                            DeleteItem(
                                onItemClick = { profileViewModel.clearHistory() }
                            )
                        }
                    }
                }
            }
        }
    }
}
