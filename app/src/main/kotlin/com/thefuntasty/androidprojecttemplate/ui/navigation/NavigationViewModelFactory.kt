package com.thefuntasty.androidprojecttemplate.ui.navigation

import com.thefuntasty.mvvm.factory.BaseViewModelFactory
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

class NavigationViewModelFactory @Inject constructor(
    override val viewModelProvider: Provider<NavigationViewModel>
) : BaseViewModelFactory<NavigationViewModel>() {
    override val viewModelClass: KClass<NavigationViewModel> = NavigationViewModel::class
}
