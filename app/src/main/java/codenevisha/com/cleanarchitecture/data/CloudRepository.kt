package codenevisha.com.cleanarchitecture.data

import codenevisha.com.cleanarchitecture.data.source.cloud.ApiService
import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import io.reactivex.Single
import javax.inject.Inject

class CloudRepository @Inject constructor(val api: ApiService): BaseCloudRepository {

    override fun getArticles(): Single<ArticleModel> {
    return  api.getArticles()
    }
}