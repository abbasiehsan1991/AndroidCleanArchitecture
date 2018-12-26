package codenevisha.com.cleanarchitecture.data.restful

import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines?country=us&category=business")
    fun getArticles(
        @Query("apiKey") userApiKey: String)
            : Single<ArticleModel>
}