package codenevisha.com.cleanarchitecture.presenter.base

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import codenevisha.com.cleanarchitecture.presenter.home.HomeAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions


/**
 * Contains [BindingAdapter]s for the [T] list or
 * Setting images into an [ImageView]
 */
class BaseBindings {

    companion object {
        private val TAG = "ListBindings"

        @JvmStatic
        @BindingAdapter("app:adapter")
        fun <T> setItems(recyclerView: RecyclerView, items: List<T>?) {

            Log.d(TAG, "articles:[$items]")

            if (recyclerView.adapter is HomeAdapter) {

                if (items != null) {
                    (recyclerView.adapter as HomeAdapter).swapData(items)
                }

            }
        }

        @JvmStatic
        @BindingAdapter("app:loadImage")
        fun setImageResource(view: ImageView, imageUrl: String?) {

            val context = view.context

            val options = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)


            imageUrl?.let {

                Glide.with(context)
                    .setDefaultRequestOptions(options)
                    .load(imageUrl)
                    .transition(DrawableTransitionOptions.withCrossFade(1000))
                    .into(view)
            }
        }

    }
}
