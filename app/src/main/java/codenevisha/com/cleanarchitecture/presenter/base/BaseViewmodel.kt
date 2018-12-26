package codenevisha.com.cleanarchitecture.presenter.base

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewmodel : ViewModel(), LifecycleObserver {

    val compositeDisposable = CompositeDisposable()

    abstract fun onStart()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}