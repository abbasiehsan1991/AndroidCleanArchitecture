package codenevisha.com.cleanarchitecture.presenter


import android.arch.lifecycle.Observer
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import codenevisha.com.cleanarchitecture.R
import codenevisha.com.cleanarchitecture.databinding.FragmentHomeBinding
import codenevisha.com.cleanarchitecture.domain.model.Article
import codenevisha.com.cleanarchitecture.presenter.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    companion object {
        val CLASS_NAME = HomeFragment::class.java.simpleName
        private val TAG  = HomeFragment::class.java.simpleName
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

            articles.observe(this@HomeFragment , Observer {
                Log.d(TAG , "articles [${it?.size}]")
            })

            isLoadingData.observe(this@HomeFragment  , Observer {
                Toast.makeText(activity , "Vale is [$isLoadingData]"  , Toast.LENGTH_SHORT).show()
            })

            prepareRvHome()

        }
    }

    private fun prepareRvHome(){

        rv_main_articles.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL , false)
        rv_main_articles.adapter = HomeAdapter(ArrayList<Article>(0))
        rv_main_articles.hasFixedSize()

    }

}
