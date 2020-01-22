package codenevisha.com.cleanarchitecture.presenter.home

import android.arch.core.executor.testing.InstantTaskExecutorRule
import codenevisha.com.cleanarchitecture.RxSchedulersOverrideRule
import codenevisha.com.cleanarchitecture.domain.model.Article
import codenevisha.com.cleanarchitecture.domain.model.SuccessResponse
import codenevisha.com.cleanarchitecture.domain.model.UseCaseResponse
import codenevisha.com.cleanarchitecture.domain.usecase.SingleUseCase
import codenevisha.com.cleanarchitecture.domain.usecase.article.GetArticleListUseCase
import codenevisha.com.cleanarchitecture.domain.usecase.article.GetUserNameFromPref
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rule: TestRule = RxSchedulersOverrideRule()

    @Mock
    lateinit var getArticleListUseCase: GetArticleListUseCase

    @Mock
    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    lateinit var onResponse: (UseCaseResponse<Article>) -> Unit

    private lateinit var sut: HomeViewModel

    @Before
    fun setup() {
        sut = HomeViewModel(getArticleListUseCase)
    }

    @Test
    fun `live data's must have valid data in viewModel after receiving data from server`() {

        // GIVEN
        val mockedResponse = com.nhaarman.mockito_kotlin.mock<Article>()
        val testSingle = Single.just(mockedResponse)
        val singleUseCase =
            com.nhaarman.mockito_kotlin.mock<SingleUseCase<Article>>(defaultAnswer = Mockito.CALLS_REAL_METHODS)

        whenever(singleUseCase.execute()).thenReturn(testSingle)

        val disposable = singleUseCase.execute(compositeDisposable, onResponse)
        whenever(getArticleListUseCase.execute(any(), any())).thenReturn(disposable)

        // WHEN
        sut.onStart()

        // THEN
        verify(getArticleListUseCase).execute(any(), any())

        Assert.assertEquals(
            "isLoading must be [false] after receiving data from server but it's [true]",
            false,
            sut.isLoadingData.value
        )

    }

}
