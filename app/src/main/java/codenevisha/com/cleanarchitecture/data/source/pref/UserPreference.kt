package codenevisha.com.cleanarchitecture.data.source.pref

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/11 10:14
 */
class UserPreference(val name: String) : DefaultPreference(name) {

    companion object {
        //PREF NAME
        const val PREF_NAME = "user_pref"

        //KEYS
        const val KEY_USER_NAME = "USER_NAME"
    }

}