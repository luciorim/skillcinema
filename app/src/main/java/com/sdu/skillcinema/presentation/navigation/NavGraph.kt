package com.sdu.skillcinema.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sdu.skillcinema.presentation.home_page.HomePageScreen
import com.sdu.skillcinema.presentation.movie_collection.MovieCollectionScreen

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

            composable("movieCollection/{type}") { backStackEntry ->
            MovieCollectionScreen(navController = navHostController)
        }
    }
}
