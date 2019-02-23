package codenevisha.com.cleanarchitecture.di.builder

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Like activity and fragment, all the viewModels must be declared in a builder class
 * Also, all of the ViewModel dependencies must be provided here.
 * like repositories, usecases, ...
 */

@Module(includes = [
    (RepositoryBuilder::class),
    (AppViewModelBuilder::class) //ViewModelBuilder
])
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}