package codenevisha.com.cleanarchitecture.data

import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import io.reactivex.Single

interface BaseCloudRepository {
        fun getArticles(): Single<ArticleModel>
}