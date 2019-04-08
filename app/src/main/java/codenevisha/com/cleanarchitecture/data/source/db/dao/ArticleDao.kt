package codenevisha.com.cleanarchitecture.data.source.db.dao

import android.arch.persistence.room.*
import codenevisha.com.cleanarchitecture.domain.model.Article

/**
 *
 *Created by Ehsan Abbasi for AndroidCleanArchitecture at 4/8/19
 *
 * Provide access to [Article] in database
 */

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(article: Article): Long

    @Query("SELECT * FROM Article")
    fun getAllArticles(): MutableList<Article>

    @Query("SELECT * FROM Article WHERE id= :articleId")
    fun getArticleById(articleId: Int):Article?

    @Delete
    fun deleteArticle(article: Article)

    @Query("DELETE FROM Article")
    fun deleteAllArticles()

    @Update
    fun updateArticle(article: Article)

}