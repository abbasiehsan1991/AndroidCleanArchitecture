package codenevisha.com.cleanarchitecture.presenter

import android.util.Log
import codenevisha.com.cleanarchitecture.R
import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import codenevisha.com.cleanarchitecture.domain.model.ErrorResponse
import codenevisha.com.cleanarchitecture.domain.model.SuccessResponse
import codenevisha.com.cleanarchitecture.domain.model.UseCaseResponse
import codenevisha.com.cleanarchitecture.domain.usecase.base.GetHomeUseCase
import codenevisha.com.cleanarchitecture.presenter.base.BaseViewModel
import codenevisha.com.cleanarchitecture.presenter.util.ELog
import javax.inject.Inject


class HomeViewModel @Inject constructor(
    private val getHomeUseCase: GetHomeUseCase
) : BaseViewModel() {

    companion object {
        val TAG = HomeViewModel::class.java.simpleName
    }

    init {
        Log.d(TAG, "INITIALIZED HOME VIEW MODEL :0")

        empty.value = true
        loadingData.value = true

    }

    override fun onStart() {
        getHomeUseCase.execute(compositeDisposable, this::articleResponse)
    }

    private fun articleResponse(response: UseCaseResponse<ArticleModel>) {

        loadingData.value = false

        when (response) {

            is SuccessResponse -> {

                ELog.d(TAG, "RESPONSE size [${response.value.articles?.size}]")
                empty.value = response.value.articles?.isNullOrEmpty()!!
            }

            is ErrorResponse -> {


                mSnackBarText.value = R.string.error_faild_get_data

            }
        }
    }

}