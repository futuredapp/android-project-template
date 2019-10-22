package com.thefuntasty.androidprojecttemplate.ui.main

import com.thefuntasty.androidprojecttemplate.R
import com.thefuntasty.androidprojecttemplate.databinding.FragmentMainBinding
import com.thefuntasty.androidprojecttemplate.ui.base.BaseBindingFragment
import javax.inject.Inject

class MainFragment : BaseBindingFragment<MainViewModel, MainViewState, FragmentMainBinding>(),
    MainView {

    @Inject
    override lateinit var viewModelFactory: MainViewModelFactory

    override val layoutResId = R.layout.fragment_main
}
