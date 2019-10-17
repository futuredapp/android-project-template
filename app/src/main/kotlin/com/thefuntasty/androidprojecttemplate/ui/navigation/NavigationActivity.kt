package com.thefuntasty.androidprojecttemplate.ui.navigation

import android.content.Context
import android.content.Intent
import com.thefuntasty.androidprojecttemplate.R
import com.thefuntasty.androidprojecttemplate.databinding.ActivityNavigationBinding
import com.thefuntasty.androidprojecttemplate.ui.base.BaseBindingActivity
import javax.inject.Inject

class NavigationActivity :
    BaseBindingActivity<NavigationViewModel, NavigationViewState, ActivityNavigationBinding>(),
    NavigationView {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, NavigationActivity::class.java)
    }

    @Inject
    override lateinit var viewModelFactory: NavigationViewModelFactory

    override val layoutResId = R.layout.activity_navigation
}
