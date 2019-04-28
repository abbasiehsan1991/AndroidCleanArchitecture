package codenevisha.com.cleanarchitecture.presenter

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import codenevisha.com.cleanarchitecture.R
import codenevisha.com.cleanarchitecture.presenter.favourite.FavouriteFragment
import codenevisha.com.cleanarchitecture.presenter.home.HomeFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mainNavigator: MainNavigator

    @Inject
    lateinit var homeFragment:HomeFragment

    @Inject
    lateinit var favouriteFragment: FavouriteFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Set as default selected item in the menu
        nav_main.selectedItemId = R.id.nav_home
        nav_main.setOnNavigationItemSelectedListener(NavigationListener())

        mainNavigator.showHomeFragment(R.id.fragment_container ,homeFragment ,supportFragmentManager)
    }

    //setting up bottom navigation menu
    private inner class NavigationListener : BottomNavigationView.OnNavigationItemSelectedListener {

        override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

            when (menuItem.itemId) {

                R.id.nav_home -> {
                    mainNavigator.showHomeFragment(R.id.fragment_container ,homeFragment ,supportFragmentManager)
                    txt_main_title.text = resources.getText(R.string.home_title)
                }

                R.id.nav_favourite -> {
                    mainNavigator.showFavouriteFragment(R.id.fragment_container ,favouriteFragment ,supportFragmentManager)
                    txt_main_title.text = resources.getText(R.string.favourite_title)
                }

                R.id.nav_category -> {
                    txt_main_title.text = resources.getText(R.string.category_title)
                    //txtToolbarSumTransaction.setVisibility(View.GONE)
                }

                R.id.nav_profile -> {
                    txt_main_title.text = resources.getText(R.string.profile_title)
                    //txtToolbarSumTransaction.setVisibility(View.GONE)
                }

            }

            return true
        }
    }
}
