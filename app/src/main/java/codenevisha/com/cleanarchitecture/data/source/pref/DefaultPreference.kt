package codenevisha.com.cleanarchitecture.data.source.pref

import android.content.Context
import android.content.SharedPreferences

open class DefaultPreference(private val name: String) {

    private lateinit var preferences: SharedPreferences

    fun create(context: Context) {
        preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    fun getValue(keyName: String, defaultValue: Any): Any = with(preferences) {

        when (defaultValue) {
            is Long -> getLong(keyName, defaultValue)
            is String -> getString(keyName, defaultValue)
            is Int -> getInt(keyName, defaultValue)
            is Boolean -> getBoolean(keyName, defaultValue)
            is Float -> getFloat(keyName, defaultValue)
            else -> throw IllegalArgumentException("Type not Allowed to save, Try primitive types.")
        }

    }

    fun putValue(keyName: String, value: Any) = with(preferences.edit()) {
        when (value) {
            is Long -> putLong(keyName, value)
            is String -> putString(keyName, value)
            is Int -> putInt(keyName, value)
            is Boolean -> putBoolean(keyName, value)
            is Float -> putFloat(keyName, value)
            else -> throw IllegalArgumentException("Type not Allowed to save, Try primitive types.")
        }.apply()
    }

    fun clear() = preferences.edit().clear().apply()
}
