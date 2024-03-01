package com.example.petapp.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.petapp.Routes
import com.example.petapp.viewmodel.UserInputViewModel

@Composable
fun FunFactNavigationGraph(userInputViewModel: UserInputViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.INPUT_SCREEN) {

        composable(route = Routes.INPUT_SCREEN) {
            UserInputScreen(userInputViewModel, showWelcomeScreen = {
                navController.navigate(Routes.WELCOME_SCREEN + "/${it.first}/${it.second}")
            })
        }

        composable(
            route = "${Routes.WELCOME_SCREEN}/{${Routes.USERNAME}}/{${Routes.ANIMAL_SELECTED}}",
            arguments = listOf(
                navArgument(Routes.USERNAME) { type = NavType.StringType },
                navArgument(Routes.ANIMAL_SELECTED) { type = NavType.StringType }
            )
        ) {
            val username = it?.arguments?.getString(Routes.USERNAME)
            val animalSelected = it?.arguments?.getString(Routes.ANIMAL_SELECTED)

            WelcomeScreen(username, animalSelected)
        }
    }
}