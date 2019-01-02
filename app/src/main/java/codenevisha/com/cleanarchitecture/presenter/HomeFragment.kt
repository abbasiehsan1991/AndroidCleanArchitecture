package codenevisha.com.cleanarchitecture.presenter


import android.arch.lifecycle.Observer
import android.widget.Toast
import codenevisha.com.cleanarchitecture.R
import codenevisha.com.cleanarchitecture.databinding.FragmentHomeBinding
import codenevisha.com.cleanarchitecture.presenter.base.BaseFragment

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    companion object {
        val CLASS_NAME = HomeFragment::class.java.simpleName
    }

    /**
     * Resource Id of main layout for view
     */
    override val layoutId: Int = R.layout.fragment_home

    override fun onViewInitialized(binding: FragmentHomeBinding) {
        super.onViewInitialized(binding)

        binding.viewmodel = viewModel
        viewModel.onStart()

        with(viewModel){

            loadingData.observe(this@HomeFragment  , Observer {
                Toast.makeText(activity , "Vale is [$loadingData]"  , Toast.LENGTH_SHORT).show()
            })
        }
    }


}
