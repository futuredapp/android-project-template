package app.futured.androidprojecttemplate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.navArgument

typealias DestinationArgumentKey = String
typealias DestinationArgumentValue = String

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList(),
    val deepLinks: List<NavDeepLink> = emptyList()
) {
    object Home : Destination(route = "home")
    object Detail : Destination(
        route = "detail/{title}?subtitle={subtitle}?value={value}",
        arguments = listOf(
            navArgument("title") {
                type = NavType.StringType
            },
            navArgument("subtitle") {
                type = NavType.StringType
                defaultValue = "Default subtitle"
            },
            navArgument("value") {
                type = NavType.StringType
                nullable = true
            }
        ),
    ) {
        fun buildRoute(title: String, subtitle: String?, value: String?): String = route
            .withArgument("title", title)
            .withArgument("subtitle", subtitle)
            .withArgument("value", value)
    }
}

/**
 * Registers provided [destination] as a composable in [NavGraphBuilder].
 */
fun NavGraphBuilder.composable(
    destination: Destination,
    content: @Composable (NavBackStackEntry) -> Unit
) = composable(
    route = destination.route,
    arguments = destination.arguments,
    deepLinks = destination.deepLinks,
    content = content
)

/**
 * Registers provided [destination] as a dialog in [NavGraphBuilder].
 */
fun NavGraphBuilder.composable(
    destination: Destination,
    dialogProperties: DialogProperties = DialogProperties(),
    content: @Composable (NavBackStackEntry) -> Unit
) = dialog(
    route = destination.route,
    arguments = destination.arguments,
    deepLinks = destination.deepLinks,
    dialogProperties = dialogProperties,
    content = content
)

/**
 * Replaces an argument placeholder defined by [key] in
 * route string with value provided in [argument].
 *
 * Example:
 * Route: "emptyScreen/{title}"
 * key: "title"
 * argument: "Hello"
 * Result: "emptyScreen/Hello"
 */
fun String.withArgument(key: DestinationArgumentKey, argument: DestinationArgumentValue?) =
    argument?.let { replace("{$key}", it) } ?: this
