package codenevisha.com.cleanarchitecture.di.module

import android.app.Application
import android.arch.persistence.room.Room
import codenevisha.com.cleanarchitecture.data.source.db.AppDatabase
import codenevisha.com.cleanarchitecture.data.source.db.dao.ArticleDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(application: Application): AppDatabase {

        return Room
            .databaseBuilder(application, AppDatabase::class.java, AppDatabase.APP_DATABASE_NAME)
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun  provideArticleDao(appDatabase: AppDatabase): ArticleDao {
        return appDatabase.articleDao
    }
}