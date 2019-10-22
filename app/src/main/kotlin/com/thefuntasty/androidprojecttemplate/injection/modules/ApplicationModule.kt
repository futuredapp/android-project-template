package com.thefuntasty.androidprojecttemplate.injection.modules

import android.content.Context
import android.content.res.Resources
import com.squareup.moshi.Moshi
import com.thefuntasty.androidprojecttemplate.App
import com.thefuntasty.androidprojecttemplate.injection.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @ApplicationContext
    fun context(app: App): Context = app

    @Singleton
    @Provides
    fun resources(@ApplicationContext context: Context): Resources = context.resources

    @Singleton
    @Provides
    fun moshi(): Moshi = Moshi.Builder()
        .build()
}
