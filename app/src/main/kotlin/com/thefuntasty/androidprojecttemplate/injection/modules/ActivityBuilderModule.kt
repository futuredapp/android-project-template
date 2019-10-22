package com.thefuntasty.androidprojecttemplate.injection.modules

import com.thefuntasty.androidprojecttemplate.ui.navigation.NavigationActivity
import com.thefuntasty.androidprojecttemplate.ui.navigation.NavigationActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [NavigationActivityModule::class])
    abstract fun mainActivity(): NavigationActivity
}
