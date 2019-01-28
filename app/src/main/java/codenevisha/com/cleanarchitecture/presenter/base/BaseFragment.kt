package codenevisha.com.cleanarchitecture.presenter.base

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.StringRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codenevisha.ir.mvvmwithdagger.ui.SnackbarMessage
import codenevisha.ir.mvvmwithdagger.ui.SnackbarUtils
import dagger.android.support.DaggerFragment
import dagger.android.support.HasSupportFragmentInjector
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseFragment<V : BaseViewModel, B : ViewDataBinding> : DaggerFragment(), BaseView<V, B>,
    HasSupportFragmentInjector {

    override lateinit var binding: B

    @Inject
    override lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: V by lazy {
        @Suppress("UNCHECKED_CAST")
        ViewModelProviders.of(this, viewModelFactory).get(
            (javaClass
                .genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<V>
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)

        binding.setLifecycleOwner(this)
        lifecycle.addObserver(viewModel)
        viewModel.onStart()



        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onViewInitialized(binding)

        setupSnakbar()

    }

    private fun setupSnakbar() {
        viewModel.mSnackBarText.observe(this, object : SnackbarMessage.SnackbarObserver {
            /**
             * Called when there is a new message to be shown.
             * @param snackbarMessageResourceId The new message, non-null.
             */
            override fun onNewMessage(snackbarMessageResourceId: Int) {

                SnackbarUtils.showSnackbar(view, getString(snackbarMessageResourceId))

            }

            override fun onNewMessage(message: String) {

                SnackbarUtils.showSnackbar(view, message)

            }

        })
    }
}