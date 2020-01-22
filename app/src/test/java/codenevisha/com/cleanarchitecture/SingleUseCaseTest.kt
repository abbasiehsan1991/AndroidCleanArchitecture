package codenevisha.com.cleanarchitecture

import codenevisha.com.cleanarchitecture.data.CloudErrorMapper
import codenevisha.com.cleanarchitecture.domain.model.*
import codenevisha.com.cleanarchitecture.domain.usecase.SingleUseCase
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 *
 *Created by Ehsan Joon for AndroidCleanArchitecture at 4/17/19
 *
 */

@RunWith(MockitoJUnitRunner::class)
class SingleUseCaseTest {

    @get:Rule
    val rule: TestRule = RxSchedulersOverrideRule()

    @Mock
    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    lateinit var onResponse: (UseCaseResponse<Any>) -> Unit

    @Mock
    lateinit var onTokenExpire: () -> Unit

    @Mock
    lateinit var errorUtil: CloudErrorMapper

    @Test
    fun `execute useCase should invoke callback with a valid response if everything is ok`() {
        // GIVEN
        val mockedResponse = com.nhaarman.mockito_kotlin.mock<Any>()
        val testSingle = Single.just(mockedResponse)
        val singleUseCase = com.nhaarman.mockito_kotlin.mock<SingleUseCase<Any>>(defaultAnswer = Mockito.CALLS_REAL_METHODS)

        whenever(singleUseCase.execute()).thenReturn(testSingle)

        // WHEN
        val disposable = singleUseCase.execute(compositeDisposable, onResponse)

        // THEN
        verify(onResponse).invoke(SuccessResponse(mockedResponse))
        verify(onTokenExpire, never()).invoke()
        verify(compositeDisposable).add(disposable)
    }

    @Test
    fun `execute use case should invoke callback with a ErrorModel if something went wrong`() {

        // GIVEN
        val t = com.nhaarman.mockito_kotlin.mock<Throwable>() //Mocking a throwable
        val mockedError = com.nhaarman.mockito_kotlin.mock<ErrorModel>() //Mocking an Error model
        val testSingle = Single.error<Any>(t) //Throw an Error with RX Single
        val singleUseCase = com.nhaarman.mockito_kotlin.mock<SingleUseCase<Any>>(defaultAnswer = Mockito.CALLS_REAL_METHODS)

        whenever(errorUtil.mapToDomainErrorException(t)).thenReturn(mockedError)
        whenever(singleUseCase.cloudErrorMapper).thenReturn(errorUtil)
        whenever(singleUseCase.execute()).thenReturn(testSingle)

        // WHEN
        val disposable = singleUseCase.execute(compositeDisposable, onResponse)

        // THEN
        verify(onResponse).invoke(ErrorResponse(mockedError))
        verify(onTokenExpire, never()).invoke()
        verify(compositeDisposable).add(disposable)
    }
}