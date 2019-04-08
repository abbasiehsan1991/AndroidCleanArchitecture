package codenevisha.com.cleanarchitecture.data.repository

import codenevisha.com.cleanarchitecture.data.BaseCloudRepository
import codenevisha.com.cleanarchitecture.data.source.db.AppDatabase
import codenevisha.com.cleanarchitecture.domain.model.Article
import codenevisha.com.cleanarchitecture.domain.repository.AppRepository
import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import io.reactivex.Single
import javax.inject.Inject


/**
 * This class will be provide
 * Articles from the server or local database
 */
class ArticleRepoImp @Inject constructor(

    private val cloudRepository: BaseCloudRepository,
    private val appDatabase: AppDatabase
) : AppRepository {
    /**
     * Return list of [Article] for available resource
     */
    override fun getArticles(): Single<ArticleModel> {
        return cloudRepository.getArticles()
    }

    /**
     * Return [Article] form database with received [id]
     * If found it
     */
    override fun getArticleByIdFromDB(articleId: Int): Article? {
        return appDatabase.articleDao.getArticleById(articleId)
    }

    /**
     * Delete received [Article]
     * If is available in database
     */
    override fun deleteArticleFromDB(article: Article) {
        appDatabase.articleDao.deleteArticle(article)
    }

    /**
     * Delete all available [Article] (s) in [AppDatabase]
     */
    override fun deleteAllArticleFromDB() {
        appDatabase.articleDao.deleteAllArticles()
    }

    /**
     * Update received [Article]
     * If it's available in [AppDatabase]
     */
    override fun updateArticleInDB(article: Article) {
        appDatabase.articleDao.updateArticle(article)
    }
}