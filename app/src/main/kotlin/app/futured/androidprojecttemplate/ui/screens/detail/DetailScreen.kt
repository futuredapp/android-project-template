package app.futured.androidprojecttemplate.ui.screens.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import app.futured.androidprojecttemplate.navigation.NavigationActions
import app.futured.androidprojecttemplate.ui.components.AddFloatingActionButton
import app.futured.androidprojecttemplate.ui.theme.ContentPadding

@Composable
fun DetailScreen(navigation: NavigationActions) {

    val viewModel = hiltViewModel<DetailViewModel>()
    val viewState = viewModel.viewState

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "DetailScreen") },
                navigationIcon = {
                    IconButton(
                        onClick = { navigation.popBackStack() },
                    ) {
                        Icon(Icons.Default.ArrowBack, "")
                    }
                }
            )
        },
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
        ) {
            Text(text = "Detail: ${viewState.counter}")
        }
    }
}