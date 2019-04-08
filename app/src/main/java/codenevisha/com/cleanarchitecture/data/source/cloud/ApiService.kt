package codenevisha.com.cleanarchitecture.data.source.cloud

import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines?country=us&category=business&apiKey=05ec1c5d916f4d379ea1ec90ed06dd09")
    fun getArticles()
            : Single<ArticleModel>

}