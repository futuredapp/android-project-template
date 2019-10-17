package com.thefuntasty.androidprojecttemplate.data.persistence

import android.content.Context
import com.orhanobut.hawk.Hawk
import com.thefuntasty.androidprojecttemplate.injection.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Persistence @Inject constructor(
    @ApplicationContext private val context: Context
){

    init {
        Hawk.init(context).build()
    }

    operator fun <T> set(key: String, value: T): Boolean = Hawk.put(key, value)

    operator fun <T> get(key: String): T = Hawk.get(key)

    operator fun <T> get(key: String, defaultValue: T): T = Hawk.get(key, defaultValue)

    fun delete(key: String): Boolean = Hawk.delete(key)

    operator fun contains(key: String): Boolean = Hawk.contains(key)

    fun clear(): Boolean = Hawk.deleteAll()

}
