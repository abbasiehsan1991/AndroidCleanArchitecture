package codenevisha.com.cleanarchitecture.data.source.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import codenevisha.com.cleanarchitecture.data.source.db.dao.ArticleDao
import codenevisha.com.cleanarchitecture.domain.model.Article

/**
 *
 *Created by Ehsan Abbasi for AndroidCleanArchitecture at 4/8/19
 *
 */

@Database(entities = [Article::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract val articleDao: ArticleDao
    companion object {
        const val APP_DATABASE_NAME= "CleanArch.db"
    }
}