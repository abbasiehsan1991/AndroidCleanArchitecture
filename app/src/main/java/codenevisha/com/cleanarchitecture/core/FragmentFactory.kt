package codenevisha.com.cleanarchitecture.core

import android.support.v4.app.FragmentManager
import codenevisha.com.cleanarchitecture.presenter.HomeFragment

object FragmentFactory{

    fun getHomeFragment(supportFragmentManager: FragmentManager): HomeFragment {
        var fragment = supportFragmentManager.findFragmentByTag(HomeFragment.CLASS_NAME)
        if (fragment == null) {
            fragment = HomeFragment()
        }
        return fragment as HomeFragment
    }

}