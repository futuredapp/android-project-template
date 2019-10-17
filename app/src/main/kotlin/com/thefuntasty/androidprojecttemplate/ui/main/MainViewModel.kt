package com.thefuntasty.androidprojecttemplate.ui.main

import com.thefuntasty.mvvm.crinteractors.BaseCrViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    override val viewState: MainViewState
) : BaseCrViewModel<MainViewState>()

