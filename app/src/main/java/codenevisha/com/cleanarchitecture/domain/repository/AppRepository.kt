package codenevisha.com.cleanarchitecture.domain.repository

import codenevisha.com.cleanarchitecture.data.source.db.AppDatabase
import codenevisha.com.cleanarchitecture.domain.model.Article
import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import io.reactivex.Single

interface AppRepository {

    /**
     * Return list of [Article] for available resource
     */
    fun getArticles():Single<ArticleModel>

    /**
     * Return [Article] form database with received [id]
     * If found it
     */
    fun getArticleByIdFromDB(articleId:Int):Article?

    /**
     * Delete received [Article]
     * If is available in database
     */
    fun deleteArticleFromDB(article:Article)

    /**
     * Delete all available [Article] (s) in [AppDatabase]
     */
    fun deleteAllArticleFromDB()

    /**
     * Update received [Article]
     * If it's available in [AppDatabase]
     */
    fun updateArticleInDB(article: Article)
}