package codenevisha.com.cleanarchitecture.domain.usecase.article

import codenevisha.com.cleanarchitecture.domain.model.Article
import codenevisha.com.cleanarchitecture.domain.repository.AppRepository
import javax.inject.Inject

/**
 *
 *Created by Ehsan Abbasi for AndroidCleanArchitecture at 4/8/19
 *
 */
class GetArticleByIdUseCase @Inject constructor(
    private val appRepository: AppRepository
){

    fun execute(articleId:Int): Article?{
        return appRepository.getArticleByIdFromDB(articleId)
    }
}