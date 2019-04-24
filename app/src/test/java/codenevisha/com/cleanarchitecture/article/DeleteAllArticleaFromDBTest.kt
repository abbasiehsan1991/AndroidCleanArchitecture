package codenevisha.com.cleanarchitecture.article

import codenevisha.com.cleanarchitecture.domain.repository.AppRepository
import codenevisha.com.cleanarchitecture.domain.usecase.article.DeleteAllArticleaFromDB
import com.nhaarman.mockito_kotlin.verify
import org.mockito.Mock
import org.mockito.Mockito.mock

/**
 *
 *Created by Ehsan Joon for AndroidCleanArchitecture at 4/17/19
 *
 */
class DeleteAllArticleaFromDBTest {

    val appRepository = mock(AppRepository::class.java)
    val deleteAllArticleaFromDB = mock(DeleteAllArticleaFromDB::class.java)

    fun verifyDeleteAllArticleFromDB(){

        deleteAllArticleaFromDB.execute()
        verify(deleteAllArticleaFromDB).execute()
    }

    fun deleteAllArticlesFromDBTest(){


    }

}