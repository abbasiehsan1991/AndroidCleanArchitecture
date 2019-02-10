package codenevisha.com.cleanarchitecture.presenter

import android.arch.lifecycle.MutableLiveData
import android.os.Parcelable
import android.util.Log
import android.view.View
import codenevisha.com.cleanarchitecture.domain.model.*
import codenevisha.com.cleanarchitecture.domain.usecase.home.GetHomeUseCase
import codenevisha.com.cleanarchitecture.presenter.base.BaseViewModel
import codenevisha.com.cleanarchitecture.presenter.util.ELog
import org.junit.internal.runners.statements.InvokeMethod
import javax.inject.Inject
import javax.security.auth.callback.Callback


class HomeViewModel @Inject constructor(
    private val getHomeUseCase: GetHomeUseCase
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
        getHomeUseCase.execute(compositeDisposable, this::articleResponse, TokenExpired())
    }

    private fun articleResponse(response: UseCaseResponse<ArticleModel>) {

        isLoadingData.value = false

        when (response) {

            is SuccessResponse -> {

                ELog.d(TAG, "RESPONSE size [${response.value.articles?.size}]")
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