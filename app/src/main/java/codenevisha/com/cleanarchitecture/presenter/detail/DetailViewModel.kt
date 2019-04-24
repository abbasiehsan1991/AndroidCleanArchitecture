package codenevisha.com.cleanarchitecture.presenter.detail

import codenevisha.com.cleanarchitecture.domain.usecase.article.GetArticleByIdUseCase
import codenevisha.com.cleanarchitecture.presenter.base.BaseViewModel
import javax.inject.Inject

/**
 *
 *Created by EA for AndroidCleanArchitecture at 4/9/19
 *
 */
class DetailViewModel  @Inject constructor(
    val getArticleById:GetArticleByIdUseCase
) : BaseViewModel() {

    override fun onStart() {
    }




}