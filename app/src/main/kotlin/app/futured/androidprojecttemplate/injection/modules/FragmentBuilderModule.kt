package app.futured.androidprojecttemplate.injection.modules

import app.futured.androidprojecttemplate.ui.main.MainFragment
import app.futured.androidprojecttemplate.ui.main.MainFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun mainFragment(): MainFragment
}
