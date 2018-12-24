package codenevisha.com.cleanarchitecture.di.component

import codenevisha.com.cleanarchitecture.core.App
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component
interface CoreComponent :AndroidInjector<App>{
}