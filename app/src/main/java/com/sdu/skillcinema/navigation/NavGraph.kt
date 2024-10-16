package com.sdu.skillcinema.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sdu.skillcinema.views.screens.Homepage

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController, startDestination = "homepage") { //todo: change to constants
        composable("homepage") {
            Homepage()
        }

        composable("search") {
            Search()
        }

        composable("profile") {
            Profile()
        }
    }
}