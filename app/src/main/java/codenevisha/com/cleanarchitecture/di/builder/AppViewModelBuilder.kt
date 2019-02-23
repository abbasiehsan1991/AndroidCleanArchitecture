package codenevisha.com.cleanarchitecture.di.builder

import android.arch.lifecycle.ViewModel
import codenevisha.com.cleanarchitecture.presenter.home.HomeViewModel
import codenevisha.com.cleanarchitecture.di.qualifier.ViewModelKey
import codenevisha.com.cleanarchitecture.presenter.favourite.FavouriteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * All viewModels that we need them
 * Have to mention them here
 */
@Module
abstract class AppViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavouriteViewModel::class)
    abstract fun bindFavouriteViewModel(viewModel: FavouriteViewModel): ViewModel

}