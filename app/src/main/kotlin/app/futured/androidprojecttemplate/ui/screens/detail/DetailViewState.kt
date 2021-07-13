package app.futured.androidprojecttemplate.ui.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DetailViewState @Inject constructor() {
    var counter by mutableStateOf(0)
}