package app.futured.androidprojecttemplate.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.futured.androidprojecttemplate.ui.theme.ContentPadding

@Composable
fun HomeScreen(navigate: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(ContentPadding)
            .fillMaxSize()
            .clickable { navigate() }
    ) {
        Text(text = "Home")
    }
}