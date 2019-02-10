package codenevisha.com.cleanarchitecture


import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import codenevisha.com.cleanarchitecture.presenter.MainActivity
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.mockito.junit.MockitoJUnitRunner
import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class ExampleInstrumentedTest {


    @Rule @JvmField
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(
        MainActivity::class.java,
        true,
        false
    )

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("codenevisha.com.cleanarchitecture", appContext.packageName)
    }

}
