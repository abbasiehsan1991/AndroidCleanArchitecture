package codenevisha.com.cleanarchitecture.domain.usecase.base

import codenevisha.com.cleanarchitecture.data.CloudErrorMapper
import codenevisha.com.cleanarchitecture.domain.model.ErrorModel
import codenevisha.com.cleanarchitecture.domain.model.ErrorResponse
import codenevisha.com.cleanarchitecture.domain.model.SuccessResponse
import codenevisha.com.cleanarchitecture.domain.model.UseCaseResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T>(val errorUtil: CloudErrorMapper) : UseCase<Single<T>>() {

    fun execute(

        compositeDisposable: CompositeDisposable,
        onResponse: ((UseCaseResponse<T>) -> Unit)

    ): Disposable {

        return this.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(

                {
                    onResponse(SuccessResponse(it))
                },
                {
                    val error: ErrorModel = errorUtil.mapToDomainErrorException(it)

                    onResponse(ErrorResponse(error))
                }

            ).also { compositeDisposable.add(it) }
    }
}