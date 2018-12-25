package codenevisha.com.cleanarchitecture.di.builder

import codenevisha.com.cleanarchitecture.ui.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders{
    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment

}