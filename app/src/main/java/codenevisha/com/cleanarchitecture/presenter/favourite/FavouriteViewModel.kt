package codenevisha.com.cleanarchitecture.presenter.favourite

import codenevisha.com.cleanarchitecture.presenter.base.BaseViewModel
import codenevisha.com.cleanarchitecture.presenter.util.ELog
import javax.inject.Inject


class FavouriteViewModel @Inject constructor() : BaseViewModel() {

    companion object {
        val TAG = FavouriteViewModel::class.java.simpleName
    }

    init {

        ELog.print(ELog.Level.D , TAG, "INITIALIZED FAVOURITE VIEW MODEL :0")

        empty.value = true
        isLoadingData.value = true

    }

    override fun onStart() {

    }

}