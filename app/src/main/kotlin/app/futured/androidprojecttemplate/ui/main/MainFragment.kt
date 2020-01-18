package app.futured.androidprojecttemplate.ui.main

import app.futured.androidprojecttemplate.R
import app.futured.androidprojecttemplate.databinding.FragmentMainBinding
import app.futured.androidprojecttemplate.ui.base.BaseBindingFragment
import javax.inject.Inject

class MainFragment : BaseBindingFragment<MainViewModel, MainViewState, FragmentMainBinding>(),
    MainView {

    @Inject
    override lateinit var viewModelFactory: MainViewModelFactory

    override val layoutResId = R.layout.fragment_main
}
