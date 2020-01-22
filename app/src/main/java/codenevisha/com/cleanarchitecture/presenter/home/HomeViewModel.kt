package codenevisha.com.cleanarchitecture.presenter.home

import android.arch.lifecycle.MutableLiveData
import codenevisha.com.cleanarchitecture.domain.model.*
import codenevisha.com.cleanarchitecture.domain.usecase.article.GetArticleListUseCase
import codenevisha.com.cleanarchitecture.presenter.base.BaseViewModel
import javax.inject.Inject


class HomeViewModel @Inject constructor(
    private val getArticleListUseCase: GetArticleListUseCase
) : BaseViewModel() {
    companion object {
        val TAG = HomeViewModel::class.java.simpleName
    }

    val articles = MutableLiveData<MutableList<Article>>()
    val errorModel = MutableLiveData<ErrorModel>()

    init {

        empty.value = true
        isLoadingData.value = true

    }

    override fun onStart() {
        getArticleListUseCase.execute(compositeDisposable, ::articleResponse)
    }

    private fun articleResponse(response: UseCaseResponse<ArticleModel>) {

        isLoadingData.value = false

        when (response) {

            is SuccessResponse -> {

                empty.value = response.value.articles?.isNullOrEmpty()!!

                response.value.articles?.let {
                    articles.value = it
                }
            }

            is ErrorResponse -> {

                errorModel.value = response.error

                response.error.message?.let {

                    mSnackBarText.value = it
                }

            }
        }
    }

}