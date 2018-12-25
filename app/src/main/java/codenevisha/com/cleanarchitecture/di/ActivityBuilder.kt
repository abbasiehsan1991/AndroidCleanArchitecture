package codenevisha.com.cleanarchitecture.di

import codenevisha.com.cleanarchitecture.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityProvider::class])
    abstract fun buildMainActivity(): MainActivity

}