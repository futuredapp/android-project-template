package app.futured.androidprojecttemplate.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.futured.androidprojecttemplate.navigation.Destination
import app.futured.androidprojecttemplate.navigation.NavigationActions
import app.futured.androidprojecttemplate.navigation.composable
import app.futured.androidprojecttemplate.ui.screens.detail.DetailScreen
import app.futured.androidprojecttemplate.ui.screens.home.HomeScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppUI() {
    val navController = rememberNavController()
    val navActions = remember { NavigationActions(navController) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val coroutineScope = rememberCoroutineScope()

    NavHost(
        navController = navController,
        startDestination = Destination.Home.route
    ) {
        composable(Destination.Home) {
            HomeScreen(navigate = {
                navActions.navigateToDetailScreen(
                    title = "All podcasts",
                    subtitle = "Subtitle from argument",
                    value = "ASDF"
                )
            })
        }
        composable(Destination.Detail) {
            DetailScreen()
        }
    }
}