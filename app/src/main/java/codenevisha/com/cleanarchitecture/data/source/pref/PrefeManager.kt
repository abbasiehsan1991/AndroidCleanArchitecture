package codenevisha.com.cleanarchitecture.data.source.pref

import android.content.Context

/**
 * Cluster your Preferences in order to make them organized :)
 */
class PrefeManager constructor(val context: Context) {

    /**
     * All Preferences related to user can store here ;)
     */

    val userPreference: DefaultPreference by lazy {

        val preference = UserPreference(UserPreference.PREF_NAME)
        preference.create(context)
        preference

    }

}


