package codenevisha.com.cleanarchitecture.domain.usecase.base

import codenevisha.com.cleanarchitecture.data.CloudErrorMapper
import codenevisha.com.cleanarchitecture.domain.AppRepository
import codenevisha.com.cleanarchitecture.domain.model.ArticleModel
import io.reactivex.Single
import javax.inject.Inject

class GetHomeUseCase @Inject constructor(

    errorUtil: CloudErrorMapper,
    private val appRepository: AppRepository

) : SingleUseCase<ArticleModel>(errorUtil) {

    override fun execute(): Single<ArticleModel> {
        return appRepository.getArticles()
    }
}