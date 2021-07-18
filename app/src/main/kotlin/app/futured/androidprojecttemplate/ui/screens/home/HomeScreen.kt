package app.futured.androidprojecttemplate.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import app.futured.androidprojecttemplate.navigation.NavigationDestinations
import app.futured.androidprojecttemplate.ui.components.AddFloatingActionButton
import app.futured.androidprojecttemplate.ui.components.Showcase
import app.futured.androidprojecttemplate.ui.theme.ContentPadding

@Composable
fun HomeScreen(
    navigation: NavigationDestinations,
    viewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        with(viewModel) {
            observeEvents {
                onEvent<NavigateToDetailEvent> {
                    navigation.navigateToDetailScreen(
                        title = "Demo",
                        subtitle = "Subtitle",
                        value = "Demo Subtitle"
                    )
                }
            }
        }
    }

    with(viewModel.viewState) {
        Home.Content(
            viewModel,
            counter
        )
    }
}

object Home {

    interface Actions {
        fun navigateToDetailScreen() = Unit
        fun incrementCounter() = Unit
    }

    object PreviewActions : Actions

    @Composable
    fun Content(
        actions: Actions,
        counter: Int
    ) {
        Scaffold(
            topBar = { TopAppBar(title = { Text(text = "HomeScreen") }) },
            floatingActionButton = {
                AddFloatingActionButton(
                    onClick = {
                        actions.incrementCounter()
                    }
                )
            }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(ContentPadding)
                    .fillMaxSize()
                    .clickable {
                        actions.navigateToDetailScreen()
                    }
            ) {
                Text(text = "Home: $counter")
            }
        }
    }
}

@Preview
@Composable
fun HomeContentPreview() {
    Showcase(true) {
        Home.Content(
            Home.PreviewActions,
            5
        )
    }
}
