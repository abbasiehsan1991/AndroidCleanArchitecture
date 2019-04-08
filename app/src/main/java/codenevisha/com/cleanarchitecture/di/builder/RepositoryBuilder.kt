package codenevisha.com.cleanarchitecture.di.builder

import codenevisha.com.cleanarchitecture.data.repository.ArticleRepoImp
import codenevisha.com.cleanarchitecture.domain.repository.AppRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBuilder {
    @Binds
    abstract fun bindsMovieRepository(repoImp: ArticleRepoImp): AppRepository
}