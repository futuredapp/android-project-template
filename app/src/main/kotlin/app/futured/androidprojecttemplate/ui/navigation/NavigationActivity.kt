package app.futured.androidprojecttemplate.ui.navigation

import android.content.Context
import android.content.Intent
import app.futured.androidprojecttemplate.R
import app.futured.androidprojecttemplate.databinding.ActivityNavigationBinding
import app.futured.androidprojecttemplate.ui.base.BaseBindingActivity
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
