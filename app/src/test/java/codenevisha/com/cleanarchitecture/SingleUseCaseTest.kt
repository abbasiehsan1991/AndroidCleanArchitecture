package codenevisha.com.cleanarchitecture

import codenevisha.com.cleanarchitecture.data.CloudErrorMapper
import codenevisha.com.cleanarchitecture.domain.model.UseCaseResponse
import codenevisha.com.cleanarchitecture.domain.usecase.SingleUseCase
import io.reactivex.disposables.CompositeDisposable
import org.junit.Rule
import org.junit.rules.TestRule
import org.mockito.Mockito.mock

/**
 *
 *Created by Ehsan Joon for AndroidCleanArchitecture at 4/17/19
 *
 */
class SingleUseCaseTest {

    @get:Rule
    val rule: TestRule = RxSchedulersOverrideRule()

    val singleUseCase = mock(SingleUseCase::class.java)

    val cloudErrorMapper = mock(CloudErrorMapper::class.java)

    val compositeDisposable = mock(CompositeDisposable::class.java)

    val onResponse = mock(UseCaseResponse::class.java)

}