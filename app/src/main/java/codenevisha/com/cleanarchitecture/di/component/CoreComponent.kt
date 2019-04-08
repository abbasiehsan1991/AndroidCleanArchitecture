package codenevisha.com.cleanarchitecture.di.component

import android.app.Application
import codenevisha.com.cleanarchitecture.core.App
import codenevisha.com.cleanarchitecture.di.builder.ActivityBuilder
import codenevisha.com.cleanarchitecture.di.builder.ViewModelBuilder
import codenevisha.com.cleanarchitecture.di.module.ContextModule
import codenevisha.com.cleanarchitecture.di.module.DatabaseModule
import codenevisha.com.cleanarchitecture.di.module.NetworkModule
import codenevisha.com.cleanarchitecture.di.module.PreferenceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        ActivityBuilder::class,
        ViewModelBuilder::class,
        ContextModule::class,
        PreferenceModule::class
    ]
)
interface CoreComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }


}
