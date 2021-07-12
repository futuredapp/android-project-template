package app.futured.androidprojecttemplate.navigation

import androidx.navigation.NavController

/**
 * Class that triggers navigation actions on provided [navController].
 */
class NavigationActions(private val navController: NavController) {

    fun navigateToHome() = navController.navigate(Destination.Home.route) {
        popUpTo(navController.graph.startDestinationId)
        launchSingleTop = true
    }

    fun navigateToDetailScreen(title: String, subtitle: String? = null, value: String? = null) =
        navController.navigate(Destination.Detail.buildRoute(title, subtitle, value))
}