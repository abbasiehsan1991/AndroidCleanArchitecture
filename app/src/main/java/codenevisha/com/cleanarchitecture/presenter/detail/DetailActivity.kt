package codenevisha.com.cleanarchitecture.presenter.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import codenevisha.com.cleanarchitecture.R
import codenevisha.com.cleanarchitecture.domain.model.Article
import codenevisha.com.cleanarchitecture.presenter.MainNavigator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mainNavigator: MainNavigator

  /*  @Inject
    lateinit var detailFragment: DetailFragment*/

    companion object {
        private const val EXTRA_KEY_ARTICLE = "extraKeyArticle"

        fun newIntent(context: Context, article: Article): Intent {

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_KEY_ARTICLE, article)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val article = intent.getParcelableExtra<Article>(EXTRA_KEY_ARTICLE)

        mainNavigator.showDetailFragment(
            R.id.detail_fragment_container,
            DetailFragment.newInstance(article),
            supportFragmentManager,
            article
        )
    }


}
