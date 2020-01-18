package app.futured.androidprojecttemplate.injection.modules

import app.futured.androidprojecttemplate.ui.navigation.NavigationActivity
import app.futured.androidprojecttemplate.ui.navigation.NavigationActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [NavigationActivityModule::class])
    abstract fun mainActivity(): NavigationActivity
}
