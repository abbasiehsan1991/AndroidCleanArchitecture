package codenevisha.com.cleanarchitecture.di

import android.arch.lifecycle.ViewModelProvider
import codenevisha.com.cleanarchitecture.ui.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [
    (RepositoryBuilder::class),
    (AppViewModelBuilder::class)
])
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}