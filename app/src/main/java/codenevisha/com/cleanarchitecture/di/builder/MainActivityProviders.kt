package codenevisha.com.cleanarchitecture.di.builder

import codenevisha.com.cleanarchitecture.presenter.detail.DetailFragment
import codenevisha.com.cleanarchitecture.presenter.favourite.FavouriteFragment
import codenevisha.com.cleanarchitecture.presenter.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * We put all fragments in {@MainActivity},
 * From here we let dagger knows these in compile time :)
 */

@Module
abstract class MainActivityProviders{

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun provideHomeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun provideFavouriteFragment(): FavouriteFragment
}