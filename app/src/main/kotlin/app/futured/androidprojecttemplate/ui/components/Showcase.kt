package app.futured.androidprojecttemplate.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import app.futured.androidprojecttemplate.ui.theme.AppTheme

/**
 * Preview surface wrapper
 */
@Composable
fun Showcase(darkMode: Boolean = false, content: @Composable () -> Unit) {
    AppTheme(darkTheme = darkMode) {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}
