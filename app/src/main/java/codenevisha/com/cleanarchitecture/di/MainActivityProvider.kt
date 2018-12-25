package codenevisha.com.cleanarchitecture.di

import codenevisha.com.cleanarchitecture.ui.HomeFragment
import dagger.Module

@Module
abstract class MainActivityProvider {

    abstract fun provideHomeFragment(): HomeFragment

}