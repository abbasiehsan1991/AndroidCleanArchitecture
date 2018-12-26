package codenevisha.com.cleanarchitecture.di.builder

import codenevisha.com.cleanarchitecture.presenter.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders {

    @ContributesAndroidInjector()
    abstract fun provideHomeFragment(): HomeFragment

}