package app.futured.androidprojecttemplate.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import app.futured.androidprojecttemplate.navigation.NavigationActions
import app.futured.androidprojecttemplate.ui.components.AddFloatingActionButton
import app.futured.androidprojecttemplate.ui.theme.ContentPadding

@Composable
fun HomeScreen(navigation: NavigationActions) {
    val viewModel = hiltViewModel<HomeViewModel>()
    val viewState = viewModel.viewState

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "HomeScreen") }) },
        floatingActionButton = {
            AddFloatingActionButton(onClick = {
                viewModel.incrementCounter()
            })
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(ContentPadding)
                .fillMaxSize()
                .clickable {
                    navigation.navigateToDetailScreen(
                        title = "All podcasts",
                        subtitle = "Subtitle from argument",
                        value = "ASDF"
                    )
                }
        ) {
            Text(text = "Home: ${viewState.counter}")
        }
    }
}