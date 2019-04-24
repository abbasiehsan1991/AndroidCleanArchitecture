package codenevisha.com.cleanarchitecture.di.builder

import codenevisha.com.cleanarchitecture.presenter.detail.DetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *
 *Created by Ehsan Joon for AndroidCleanArchitecture at 4/22/19
 *
 */
@Module
abstract class DetailActivityProvider {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun provideDetailFragment(): DetailFragment

}

