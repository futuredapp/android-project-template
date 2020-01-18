package app.futured.androidprojecttemplate.injection.components

import app.futured.androidprojecttemplate.App
import app.futured.androidprojecttemplate.injection.modules.ActivityBuilderModule
import app.futured.androidprojecttemplate.injection.modules.ApplicationModule
import app.futured.androidprojecttemplate.injection.modules.FragmentBuilderModule
import app.futured.androidprojecttemplate.injection.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    ActivityBuilderModule::class,
    FragmentBuilderModule::class,
    NetworkModule::class
]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>
}
