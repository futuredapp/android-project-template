package app.futured.androidprojecttemplate.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import app.futured.androidprojecttemplate.ui.theme.AppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppUI() {
    AppTheme {
        NavGraph()
    }
}
