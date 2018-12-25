package codenevisha.com.cleanarchitecture.core

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

class App :Application(){

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}