package codenevisha.com.cleanarchitecture.presenter.util

import android.util.Log
import codenevisha.com.cleanarchitecture.BuildConfig

object ELog {

    val TAG = ELog::class.java.simpleName

    enum class Level {
        V,
        D,
        E,
        W,
        I,
        A
    }

    fun print(
        _Level: Level = ELog.Level.D,
        message: String
    ) {
        printLog(_Level, TAG, message, true)
    }

    fun print(
        _Level: Level = ELog.Level.D,
        tag: String = TAG,
        message: String,
        onlyDebug: Boolean = true
    ) {

        printLog(_Level, tag, message, onlyDebug)

    }

    private fun printLog(
        _Level: Level = ELog.Level.D,
        tag: String = TAG,
        message: String,
        onlyDebug: Boolean = true
    ) {

        if (onlyDebug && !BuildConfig.DEBUG)
            return

        when (_Level) {

            ELog.Level.V -> Log.v(tag, message)

            ELog.Level.D -> Log.d(tag, message)

            ELog.Level.E -> Log.e(tag, message)

            ELog.Level.I -> Log.i(tag, message)

            ELog.Level.W -> Log.w(tag, message)

        }
    }
}

