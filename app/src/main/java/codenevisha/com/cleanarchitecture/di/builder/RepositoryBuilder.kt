package codenevisha.com.cleanarchitecture.di.builder

import codenevisha.com.cleanarchitecture.data.repository.AppRepoImp
import codenevisha.com.cleanarchitecture.domain.AppRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBuilder {
    @Binds
    abstract fun bindsMovieRepository(repoImp: AppRepoImp): AppRepository
}