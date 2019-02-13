package codenevisha.com.cleanarchitecture.domain.repository

import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import io.reactivex.Single

interface AppRepository {
    fun getArticles():Single<ArticleModel>
}