package codenevisha.com.cleanarchitecture.article

import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import codenevisha.com.cleanarchitecture.domain.repository.AppRepository
import codenevisha.com.cleanarchitecture.domain.usecase.article.GetArticleListUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Single
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

/**
 *
 *Created by Ehsan Joon for AndroidCleanArchitecture at 4/17/19
 *
 */
class GetArticleListUseCaseTest {

    val appRepository = mock(AppRepository::class.java)
    val getArticleListUseCaseTest = mock(GetArticleListUseCase::class.java)

    @Test
    fun verifyGetArticleList() {

        getArticleListUseCaseTest.execute()

        verify(getArticleListUseCaseTest).execute()
    }

    @Test
    fun getArticleList() {

        val mockedSingle = mock<Single<ArticleModel>>()
        Mockito.`when`(getArticleListUseCaseTest.execute()).thenReturn(mockedSingle)

        val result = getArticleListUseCaseTest.execute()

        MatcherAssert.assertThat("Received result [$result] and mocked SingleArticleModel [$mockedSingle] must be matches on each other!" , result , CoreMatchers.`is`(mockedSingle))
    }
}