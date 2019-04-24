package codenevisha.com.cleanarchitecture.presenter.home

import codenevisha.com.cleanarchitecture.domain.model.Article

/**
 *
 *Created by EA for AndroidCleanArchitecture at 4/9/19
 *
 */
interface HomeAdapterListener {

    fun onArticleClickListener(article: Article)

}