package app.futured.androidprojecttemplate.ui.navigation

import com.thefuntasty.mvvm.crinteractors.BaseCrViewModel
import javax.inject.Inject

class NavigationViewModel @Inject constructor(
    override val viewState: NavigationViewState
) : BaseCrViewModel<NavigationViewState>()
