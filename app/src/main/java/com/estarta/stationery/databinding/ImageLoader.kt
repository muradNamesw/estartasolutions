package com.estarta.stationery.databinding

import android.graphics.drawable.Drawable
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy

import com.estarta.stationery.R
import com.bumptech.glide.request.RequestOptions
import androidx.core.content.ContextCompat
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target


object ImageLoader {


    private val TAG = "ImageLoader"

    @JvmStatic
    @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, imageUrl: String) {

        Log.e(TAG, "loadImage $imageUrl")
        val context = view.context

        val progressLoading = LayoutInflater.from(context).inflate(R.layout.state_old_loading_list , null).apply {
            layoutParams = view.layoutParams
        }

        var parent = (view.parent as ViewGroup)

        parent.run {
            removeView(view)
            addView(progressLoading)
            parent = (progressLoading.parent as ViewGroup)
        }

        val glideCallback = object : RequestListener<Drawable> {
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {

                Handler().post {
                    view.setImageDrawable(ContextCompat.getDrawable(context , R.mipmap.ic_launcher_background))
                    parent.run {
                        removeView(progressLoading)
                        addView(view)
                    }
                }
                return false
            }

            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                Handler().post {
                    view.setImageDrawable(resource)
                    parent.run {
                        removeView(progressLoading)
                        addView(view)
                    }
                }
                return true
            }
        }

        val options = RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
            .circleCrop()

        Glide.with(context)
            .load(imageUrl)
            .listener(glideCallback)
            .into(view)
    }
}
