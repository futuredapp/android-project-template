package app.futured.androidprojecttemplate.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.futured.androidprojecttemplate.navigation.Destination
import app.futured.androidprojecttemplate.navigation.NavigationActions
import app.futured.androidprojecttemplate.navigation.composable
import app.futured.androidprojecttemplate.ui.screens.detail.DetailScreen
import app.futured.androidprojecttemplate.ui.screens.home.HomeScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    navActions: NavigationActions = remember { NavigationActions(navController) }
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Home.route
    ) {
        composable(Destination.Home) {
            HomeScreen(navActions)
        }

        composable(Destination.Detail) {
            DetailScreen(navActions)
        }
    }
}