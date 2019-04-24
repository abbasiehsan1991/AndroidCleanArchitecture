package codenevisha.com.cleanarchitecture.presenter

import android.content.Context
import android.support.v4.app.FragmentManager
import codenevisha.com.cleanarchitecture.domain.model.Article
import codenevisha.com.cleanarchitecture.presenter.detail.DetailActivity
import codenevisha.com.cleanarchitecture.presenter.detail.DetailFragment
import codenevisha.com.cleanarchitecture.presenter.favourite.FavouriteFragment
import codenevisha.com.cleanarchitecture.presenter.home.HomeFragment
import javax.inject.Inject

/**
 *
 *Created by Ehsan Joon for AndroidCleanArchitecture at 4/16/19
 *
 */
class MainNavigator @Inject constructor() {

    /**
     * Go to [DetailActivity] to see details of
     * An [Article]
     */
    fun goToDetailActivity(context: Context, article: Article) {

        val intent = DetailActivity.newIntent(context, article)
        context.startActivity(intent)
    }

    fun showHomeFragment(fragmentContainer: Int, homeFragment: HomeFragment, fragmentManager: FragmentManager) {

        val fragmentTransaction = fragmentManager.beginTransaction()
            .replace(
                fragmentContainer,
                homeFragment,
                HomeFragment.CLASS_NAME
            )
        fragmentTransaction.commit()
    }

    fun showFavouriteFragment(
        fragmentContainer: Int,
        favouriteFragment: FavouriteFragment,
        fragmentManager: FragmentManager
    ) {
        val fragmentTransaction = fragmentManager.beginTransaction()
            .replace(
                fragmentContainer,
                favouriteFragment,
                FavouriteFragment.CLASS_NAME
            )
        fragmentTransaction.commit()
    }


    fun showDetailFragment(
        fragmentContainer: Int,
        detailFragment: DetailFragment,
        fragmentManager: FragmentManager,
        article: Article
    ) {
        val fragmentTransaction = fragmentManager.beginTransaction()
            .replace(
                fragmentContainer,
                detailFragment,
                DetailFragment.CLASS_NAME
            )
        fragmentTransaction.commit()
    }
}