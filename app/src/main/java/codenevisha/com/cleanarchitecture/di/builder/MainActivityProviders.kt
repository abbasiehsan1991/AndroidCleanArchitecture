package codenevisha.com.cleanarchitecture.di.builder

import codenevisha.com.cleanarchitecture.presenter.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainActivityProviders{

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun provideHomeFragment(): HomeFragment

}