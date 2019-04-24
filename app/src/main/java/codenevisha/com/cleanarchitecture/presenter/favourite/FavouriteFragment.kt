package codenevisha.com.cleanarchitecture.presenter.favourite

import android.os.Bundle
import codenevisha.com.cleanarchitecture.R
import codenevisha.com.cleanarchitecture.databinding.FragmentFavouriteBinding
import codenevisha.com.cleanarchitecture.presenter.base.BaseFragment
import javax.inject.Inject

/**
 *
 *Created by Ehsan Joon for AndroidCleanArchitecture at 2/16/19
 *
 */
class FavouriteFragment @Inject constructor() :BaseFragment<FavouriteViewModel,FragmentFavouriteBinding>() {
    companion object {
        val CLASS_NAME = FavouriteFragment::class.java.simpleName
        private val TAG  = FavouriteFragment::class.java.simpleName
    }


    @Inject
    lateinit var favouriteViewModel: FavouriteViewModel

    /**
     * default ViewModel of view, will be initialized by [viewModelFactory]
     */
    override lateinit var viewModel: FavouriteViewModel


    /**
     * Resource Id of main layout for view
     */
    override val layoutId: Int = R.layout.fragment_favourite


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = favouriteViewModel
    }


    override fun onViewInitialized(binding: FragmentFavouriteBinding) {
        super.onViewInitialized(binding)

    }
}