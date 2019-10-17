package com.thefuntasty.androidprojecttemplate.injection.modules

import com.thefuntasty.androidprojecttemplate.ui.main.MainFragment
import com.thefuntasty.androidprojecttemplate.ui.main.MainFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun mainFragment(): MainFragment
}
