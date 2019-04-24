package codenevisha.com.cleanarchitecture

import codenevisha.com.cleanarchitecture.domain.usecase.base.BaseUseCase
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test
import org.mockito.Mockito.mock

/**
 *
 *Created by Ehsan Joon for AndroidCleanArchitecture at 4/17/19
 *
 */

class BaseUseCaseTest {

    val baseUseCase = mock(BaseUseCase::class.java)

    @Test
    fun verifyExecute(){
        baseUseCase.execute()
        verify(baseUseCase).execute()
    }


}