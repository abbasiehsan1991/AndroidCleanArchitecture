package codenevisha.com.cleanarchitecture.domain.usecase

import codenevisha.com.cleanarchitecture.data.CloudErrorMapper
import codenevisha.com.cleanarchitecture.domain.model.*
import codenevisha.com.cleanarchitecture.domain.usecase.base.BaseUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T>(val cloudErrorMapper: CloudErrorMapper) : BaseUseCase<Single<T>>() {

    private val TAG = SingleUseCase::class.java.simpleName

    fun execute(

        compositeDisposable: CompositeDisposable,
        onResponse: ((UseCaseResponse<T>) -> Unit)

    ): Disposable {

        return this.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(

                {
                   // Log.d(TAG, "On Response[${it.toString()}]")
                    onResponse(SuccessResponse(it))
                },

                {

                   // Log.d(TAG, "On Error [$it]")

                    val error: ErrorModel = cloudErrorMapper.mapToDomainErrorException(it)

                    onResponse(ErrorResponse(error))
                }

            ).also {
                compositeDisposable.add(it)
            }
    }
}