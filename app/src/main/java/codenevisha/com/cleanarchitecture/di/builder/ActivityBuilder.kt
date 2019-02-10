package codenevisha.com.cleanarchitecture.di.builder


import codenevisha.com.cleanarchitecture.presenter.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityProviders::class])
    abstract fun bindMainActivity(): MainActivity

}