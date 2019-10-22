package com.thefuntasty.androidprojecttemplate.injection.components

import com.thefuntasty.androidprojecttemplate.App
import com.thefuntasty.androidprojecttemplate.injection.modules.ActivityBuilderModule
import com.thefuntasty.androidprojecttemplate.injection.modules.ApplicationModule
import com.thefuntasty.androidprojecttemplate.injection.modules.FragmentBuilderModule
import com.thefuntasty.androidprojecttemplate.injection.modules.NetworkModule
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
