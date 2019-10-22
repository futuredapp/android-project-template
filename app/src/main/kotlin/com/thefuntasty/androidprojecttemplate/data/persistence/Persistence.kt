package com.thefuntasty.androidprojecttemplate.data.persistence

import android.content.SharedPreferences
import androidx.core.content.edit
import com.squareup.moshi.Moshi
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
class Persistence @Inject constructor(
    private val moshi: Moshi,
    private val sharedPreferences: SharedPreferences
) {

    operator fun <T : Any> set(key: String, value: T) =
        sharedPreferences.edit { putString(key, moshi.adapter<T>(value::class.java).toJson(value)) }

    inline operator fun <reified T : Any> get(key: String): T =
        get(T::class, key, null)!!

    inline operator fun <reified T : Any> get(key: String, defaultValue: T): T =
        get(T::class, key, defaultValue)!!

    inline fun <reified T : Any> getOrNull(key: String): T? =
        get(T::class, key, null)

    fun delete(key: String) = sharedPreferences.edit {
        this.remove(key)
    }

    operator fun contains(key: String): Boolean = sharedPreferences.contains(key)

    fun clear() = sharedPreferences.edit { clear() }

    fun <T : Any> get(clazz: KClass<T>, key: String, defaultValue: T? = null): T? {
        val persistedValue = sharedPreferences.getString(key, null)
        return if (persistedValue == null) {
            defaultValue
        } else {
            moshi.adapter<T>(clazz.java).fromJson(persistedValue)
        }
    }
}
