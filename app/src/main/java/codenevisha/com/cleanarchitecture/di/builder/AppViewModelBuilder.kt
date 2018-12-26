package codenevisha.com.cleanarchitecture.di.builder

import android.arch.lifecycle.ViewModel
import codenevisha.com.cleanarchitecture.presenter.HomeViewModel
import codenevisha.com.cleanarchitecture.di.qualifier.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}
