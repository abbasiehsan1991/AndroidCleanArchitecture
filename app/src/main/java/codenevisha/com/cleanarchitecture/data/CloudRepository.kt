package codenevisha.com.cleanarchitecture.data

import codenevisha.com.cleanarchitecture.core.Config
import codenevisha.com.cleanarchitecture.data.restful.ApiService
import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import io.reactivex.Single
import javax.inject.Inject

class CloudRepository @Inject constructor(val api:ApiService): BaseCloudRepository {

    override fun getArticles(): Single<ArticleModel> {
    return  api.getArticles(Config.API_USER_TOKEN)
    }
}