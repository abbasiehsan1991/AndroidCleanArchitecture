package codenevisha.com.cleanarchitecture.domain.usecase.home

import codenevisha.com.cleanarchitecture.domain.model.Article
import codenevisha.com.cleanarchitecture.domain.repository.AppRepository
import javax.inject.Inject

/**
 *
 *Created by Ehsan Joon for AndroidCleanArchitecture at 4/8/19
 *
 */
class GetArticleFromDBUseCase @Inject constructor(
    private val appRepository: AppRepository
){

    fun getArticleFromDB(articleId:Int): Article?{
        return appRepository.getArticleByIdFromDB(articleId)
    }
}