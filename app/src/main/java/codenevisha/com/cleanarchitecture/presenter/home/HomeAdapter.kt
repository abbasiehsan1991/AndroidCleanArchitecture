package codenevisha.com.cleanarchitecture.presenter.home

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codenevisha.com.cleanarchitecture.BR.item
import codenevisha.com.cleanarchitecture.databinding.RvItemMainBinding
import codenevisha.com.cleanarchitecture.domain.model.Article
import codenevisha.com.cleanarchitecture.presenter.base.BaseDataBindingViewHolder

class HomeAdapter(

    private val listener: HomeAdapterListener

) : RecyclerView.Adapter<HomeAdapter.SimpleVideoHolder>() {

    private val items: MutableList<Article>

    init {
        items  = ArrayList(0)
    }

    private val TAG = HomeAdapter::class.java.simpleName


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SimpleVideoHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleVideoHolder {

        val binding = RvItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SimpleVideoHolder(binding)

    }

    inner class SimpleVideoHolder(dataBinding: ViewDataBinding) : BaseDataBindingViewHolder<Article>(dataBinding) {

        override fun onBind(article: Article): Unit = with(article) {

            dataBinding.setVariable(item, article)

            itemView.setOnClickListener(ArticleClickListener(article))
        }

        inner class ArticleClickListener(private val article: Article):View.OnClickListener{

            override fun onClick(p0: View?) {
                    listener.onArticleClickListener(article)
            }
        }

    }

    fun swapData(articles: List<*>) {
        Log.d(TAG, "swap list [${articles}]")

        items.addAll(articles as List<Article>)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }
}