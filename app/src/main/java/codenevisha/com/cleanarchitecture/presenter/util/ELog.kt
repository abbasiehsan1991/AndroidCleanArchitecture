package codenevisha.com.cleanarchitecture.presenter.util

import android.util.Log
import codenevisha.com.cleanarchitecture.BuildConfig

object ELog {

    fun v(tag: String, message: String, onlyDebug: Boolean) {

        if (onlyDebug) {

            if (BuildConfig.DEBUG)
                Log.v(tag, message)

        } else {

            Log.v(tag, message)
        }

    }

    fun d(tag: String, message: String, onlyDebug: Boolean = true) {

        if (onlyDebug) {

            if (BuildConfig.DEBUG)
                Log.d(tag, message)

        } else
            Log.d(tag, message)
    }

    fun w(tag: String, message: String, onlyDebug: Boolean=true) {

        if (onlyDebug) {

            if (BuildConfig.DEBUG)
                Log.w(tag, message)

        } else
            Log.w(tag, message)
    }

    fun e(tag: String, message: String, onlyDebug: Boolean = true) {

        if (onlyDebug) {

            if (BuildConfig.DEBUG)
                Log.e(tag, message)

        } else
            Log.e(tag, message)
    }


}
