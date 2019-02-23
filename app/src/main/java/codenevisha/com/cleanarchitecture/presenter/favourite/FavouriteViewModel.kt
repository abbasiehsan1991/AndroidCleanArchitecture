package codenevisha.com.cleanarchitecture.presenter.favourite

import android.util.Log
import codenevisha.com.cleanarchitecture.presenter.base.BaseViewModel
import javax.inject.Inject


class FavouriteViewModel @Inject constructor(
) : BaseViewModel() {
    companion object {
        val TAG = FavouriteViewModel::class.java.simpleName
    }

    init {
        Log.d(TAG, "INITIALIZED FAVOURITE VIEW MODEL :0")

        empty.value = true
        isLoadingData.value = true

    }

    override fun onStart() {

    }

}