package com.sdu.skillcinema.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sdu.skillcinema.presentation.film_page.FilmPageScreen
import com.sdu.skillcinema.presentation.home_page.HomePageScreen
import com.sdu.skillcinema.presentation.movie_collection.MovieCollectionScreen
import com.sdu.skillcinema.presentation.staff_detail.StaffDetailScreen
import com.sdu.skillcinema.presentation.staff_detail_movie.StaffDetailMoviesScreen
import com.sdu.skillcinema.presentation.staff_filmography.StaffFilmographyScreen

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController, startDestination = "homepage"
    ) { //todo: change to constants
        composable("homepage") {
            HomePageScreen(navController = navHostController)
        }

        composable("search") {
            Search()
        }

        composable("profile") {
            Profile()
        }

        composable("movieCollection/{type}") {
            MovieCollectionScreen(navController = navHostController)
        composable("movieCollection/{type}") { backStackEntry ->
        MovieCollectionScreen(navController = navHostController)
        }

        composable("staffDetails/{staffId}") {
            StaffDetailScreen(navController = navHostController)
        }

        composable("staffDetailsMovies/{staffId}") {
            StaffDetailMoviesScreen(navController = navHostController)
        }

        composable("staffFilmography/{staffId}") {
            StaffFilmographyScreen(navController = navHostController)
        }

        composable("detailMovie/{id}", arguments = listOf(navArgument("id"){ type = NavType.IntType})
        ) { backStackEntry ->
            FilmPageScreen(navController = navHostController)
        }
    }
}
