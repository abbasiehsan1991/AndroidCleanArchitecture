package codenevisha.com.cleanarchitecture.article

import codenevisha.com.cleanarchitecture.data.source.pref.PrefeManager
import codenevisha.com.cleanarchitecture.data.source.pref.UserPreference
import codenevisha.com.cleanarchitecture.domain.usecase.article.GetUserNameFromPref
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetUserNameFromPrefTest {

    private val mock_prefeManager = Mockito.mock(PrefeManager::class.java)

    @Test
    fun `verifying execute method calling`() {

        //GIVEN
        val sut = GetUserNameFromPref(mock_prefeManager)

        //WHEN
        sut.execute()

        //THEN
        verify(sut.execute())

    }

    @Test
    fun `get userName form UserPreference`(){

        //GIVEN
        val sut = GetUserNameFromPref(mock_prefeManager)
        Mockito.`when`(
            mock_prefeManager.userPreference.getValue(UserPreference.KEY_USER_NAME, UserPreference.DEFAULT_USER_NAME)).thenReturn("Ehsan")

        //WHEN
        sut.execute()

        //THEN
        Assert.assertEquals("" ,
            "Ehsan",
            sut.execute())
    }

}