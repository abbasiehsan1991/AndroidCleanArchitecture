package codenevisha.com.cleanarchitecture.presenter

import android.os.Bundle
import codenevisha.com.cleanarchitecture.R
import codenevisha.com.cleanarchitecture.core.FragmentFactory
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showHomeFragment()
    }

    private fun showHomeFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,
                FragmentFactory.getHomeFragment(supportFragmentManager), HomeFragment.CLASS_NAME)
        fragmentTransaction.commit()
    }
}
