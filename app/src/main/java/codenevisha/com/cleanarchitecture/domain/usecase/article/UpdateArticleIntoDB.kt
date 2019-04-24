package codenevisha.com.cleanarchitecture.domain.usecase.article

import codenevisha.com.cleanarchitecture.domain.model.Article
import codenevisha.com.cleanarchitecture.domain.repository.AppRepository
import javax.inject.Inject

/**
 *
 *Created by Ehsan Joon for AndroidCleanArchitecture at 4/9/19
 *
 */
class UpdateArticleIntoDB @Inject constructor(private val appRepository: AppRepository) {

    fun execute(article: Article) {
        appRepository.updateArticleInDB(article)
    }

}