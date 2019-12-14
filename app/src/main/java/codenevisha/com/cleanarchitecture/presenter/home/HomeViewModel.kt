package codenevisha.com.cleanarchitecture.presenter.home

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import codenevisha.com.cleanarchitecture.domain.model.*
import codenevisha.com.cleanarchitecture.domain.usecase.article.GetArticleListUseCase
import codenevisha.com.cleanarchitecture.domain.usecase.article.GetUserNameFromPref
import codenevisha.com.cleanarchitecture.presenter.base.BaseViewModel
import codenevisha.com.cleanarchitecture.presenter.util.ELog
import javax.inject.Inject


class HomeViewModel @Inject constructor(
    private val getArticleListUseCase: GetArticleListUseCase,
    private val getUserNameFromPref: GetUserNameFromPref
) : BaseViewModel() {
    companion object {
        val TAG = HomeViewModel::class.java.simpleName
    }

    val articles = MutableLiveData<MutableList<Article>>()
    val errorModel = MutableLiveData<ErrorModel>()

    init {
        Log.d(TAG, "INITIALIZED HOME VIEW MODEL :0")

        empty.value = true
        isLoadingData.value = true

    }

    override fun onStart() {
        getArticleListUseCase.execute(compositeDisposable, this::articleResponse, TokenExpired())
        Log.d(TAG, "UserName in preferences [${getUserNameFromPref.execute()}]")
    }

    private fun articleResponse(response: UseCaseResponse<ArticleModel>) {

        isLoadingData.value = false

        when (response) {

            is SuccessResponse -> {

                ELog.print(ELog.Level.D, TAG, "RESPONSE size [${response.value.articles?.size}]")

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