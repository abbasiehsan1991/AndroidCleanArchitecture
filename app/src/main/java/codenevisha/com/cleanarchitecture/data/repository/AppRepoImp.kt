package codenevisha.com.cleanarchitecture.data.repository

import codenevisha.com.cleanarchitecture.data.BaseCloudRepository
import codenevisha.com.cleanarchitecture.domain.repository.AppRepository
import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import io.reactivex.Single
import javax.inject.Inject


class AppRepoImp @Inject constructor(

    private val cloudRepository: BaseCloudRepository,
    private val articleModel: ArticleModel

) : AppRepository {

    override fun getArticles(): Single<ArticleModel> {
        return cloudRepository.getArticles()
    }

}