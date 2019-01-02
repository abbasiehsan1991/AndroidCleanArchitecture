package codenevisha.com.cleanarchitecture.presenter.base

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import codenevisha.com.cleanarchitecture.presenter.SnackbarMessage
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    val compositeDisposable = CompositeDisposable()
    val loadingData = MutableLiveData<Boolean>()
    val empty = MutableLiveData<Boolean>()
    val mSnackBarText = SnackbarMessage()


    abstract fun onStart()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}