package codenevisha.com.cleanarchitecture.presenter.base

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import codenevisha.com.cleanarchitecture.presenter.util.ELog
import codenevisha.ir.mvvmwithdagger.ui.SnackbarMessage
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    val compositeDisposable = CompositeDisposable()
    val isLoadingData = MutableLiveData<Boolean>()
    val empty = MutableLiveData<Boolean>()
    val mSnackBarText = SnackbarMessage()

    companion object {


        private val TAG = BaseViewModel::class.java.simpleName.toString()
    }

    abstract fun onStart()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }


    /**
     * This will call if we find it out that the user token is expired
     * There is the place that we can can do anything that we want by a user with
     * Expired token
     */
    class TokenExpired : () -> Unit {
        override fun invoke() {
            ELog.d(TAG , "User's token is expired.")
        }
    }
}