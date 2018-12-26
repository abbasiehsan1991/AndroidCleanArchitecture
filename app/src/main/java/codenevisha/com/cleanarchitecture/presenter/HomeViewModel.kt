package codenevisha.com.cleanarchitecture.presenter

import android.util.Log
import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import codenevisha.com.cleanarchitecture.domain.model.ErrorResponse
import codenevisha.com.cleanarchitecture.domain.model.SuccessResponse
import codenevisha.com.cleanarchitecture.domain.model.UseCaseResponse
import codenevisha.com.cleanarchitecture.domain.usecase.ArticleUseCase
import codenevisha.com.cleanarchitecture.presenter.base.BaseViewmodel
import javax.inject.Inject


class HomeViewModel @Inject constructor(
  private val articleUseCase: ArticleUseCase
) : BaseViewmodel() {

    val TAG = HomeViewModel::class.java.simpleName

    init {
        Log.d(TAG , "INITIALIZED HOME VIEW MODEL")
    }

    override fun onStart() {
      articleUseCase.execute(compositeDisposable, this::articleResponse)
    }

    private fun articleResponse(response: UseCaseResponse<ArticleModel>) {

        when (response) {

            is SuccessResponse ->
                Log.d(TAG, "SUCCESS RESPONSE [${response.value}]")

            is ErrorResponse ->
                Log.d(TAG, "Error RESPONSE  [${response.error}]")

        }
    }

}