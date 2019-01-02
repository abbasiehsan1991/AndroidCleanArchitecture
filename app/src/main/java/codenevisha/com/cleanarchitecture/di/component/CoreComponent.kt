package codenevisha.com.cleanarchitecture.di.component

import android.app.Application
import codenevisha.com.cleanarchitecture.core.App
import codenevisha.com.cleanarchitecture.di.builder.ActivityBuilder
import codenevisha.com.cleanarchitecture.di.module.ContextModule
import codenevisha.com.cleanarchitecture.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class,  ActivityBuilder::class, ContextModule::class])
interface CoreComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }


}
