package codenevisha.com.cleanarchitecture.di

import codenevisha.com.cleanarchitecture.data.AppRepoImp
import codenevisha.com.cleanarchitecture.data.AppRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBuilder {
    @Binds
    abstract fun bindsMovieRepository(repoImp: AppRepoImp): AppRepository
}