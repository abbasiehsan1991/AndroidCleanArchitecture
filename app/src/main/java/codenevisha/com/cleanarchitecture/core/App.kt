package codenevisha.com.cleanarchitecture.core

import codenevisha.com.cleanarchitecture.di.component.DaggerCoreComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerCoreComponent
            .builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}