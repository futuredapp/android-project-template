package app.futured.androidprojecttemplate.injection.modules

import android.content.Context
import android.content.res.Resources
import androidx.preference.PreferenceManager
import app.futured.androidprojecttemplate.App
import app.futured.androidprojecttemplate.injection.ApplicationContext
import app.futured.androidprojecttemplate.tools.serialization.ZonedDateTimeSerializer
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import org.threeten.bp.ZonedDateTime
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
    fun json(): Json = Json(from = Json.Default) {
        encodeDefaults = true
        ignoreUnknownKeys = true
        isLenient = true
        serializersModule = SerializersModule {
            contextual(ZonedDateTime::class, ZonedDateTimeSerializer)
        }
    }

    @Singleton
    @Provides
    fun sharedPrefs(@ApplicationContext context: Context) =
        PreferenceManager.getDefaultSharedPreferences(context)
}
