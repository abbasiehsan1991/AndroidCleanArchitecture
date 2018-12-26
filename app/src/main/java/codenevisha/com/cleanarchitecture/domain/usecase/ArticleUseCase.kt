package codenevisha.com.cleanarchitecture.domain.usecase

import android.util.Log
import codenevisha.com.cleanarchitecture.data.CloudErrorMapper
import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import codenevisha.com.cleanarchitecture.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class ArticleUseCase @Inject constructor(

    private val cloudErrorMapper: CloudErrorMapper

) : SingleUseCase<ArticleModel>(cloudErrorMapper) {

    val TAG  = ArticleUseCase::class.java.simpleName

    override fun execute(): Single<ArticleModel> {
        Log.d(TAG , "IN ECECUTE METHOD")
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}