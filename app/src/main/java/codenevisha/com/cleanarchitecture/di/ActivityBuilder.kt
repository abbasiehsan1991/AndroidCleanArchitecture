package codenevisha.com.cleanarchitecture.di

import codenevisha.com.cleanarchitecture.MainActivity
import dagger.android.ContributesAndroidInjector

abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityProvider::class])
    abstract fun buildMainActivity():MainActivity

}