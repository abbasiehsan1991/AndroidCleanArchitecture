package codenevisha.com.cleanarchitecture.presenter.base

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import dagger.android.support.HasSupportFragmentInjector
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<V : BaseViewModel, B : ViewDataBinding> : DaggerFragment(), BaseView<V, B>,
    HasSupportFragmentInjector {

    override lateinit var binding: B

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

        viewModel.onStart()

        return binding.root

    }

}