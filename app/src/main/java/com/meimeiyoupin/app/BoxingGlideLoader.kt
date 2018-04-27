package com.meimeiyoupin.app

import android.graphics.Bitmap
import android.widget.ImageView
import com.bilibili.boxing.loader.IBoxingCallback
import com.bilibili.boxing.loader.IBoxingMediaLoader
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.jess.arms.http.imageloader.glide.GlideArms
import com.meimeiyoupin.R

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/27$  15:01$
 * @author 郑炯
 * @version 1.0
 */

class BoxingGlideLoader : IBoxingMediaLoader {

    override fun displayThumbnail(img: ImageView, absPath: String, width: Int, height: Int) {
        val path = "file://$absPath"
        try {
            GlideArms.with(img.context)
                    .load(path)
                    .placeholder(R.mipmap.ic_boxing_default_image)
                    .transition(DrawableTransitionOptions().crossFade())
                    .centerCrop()
                    .override(width, height)
                    .into(img);
        } catch (ignore: IllegalArgumentException) {
        }
    }

    override fun displayRaw(img: ImageView, absPath: String, width: Int, height: Int, callback: IBoxingCallback?) {
        val path = "file://$absPath"

        val request = GlideArms.with(img.context)
                .asBitmap()
                .load(path)

        if (width > 0 && height > 0) {
            request.override(width, height)
        }
        request.listener(object : RequestListener<Bitmap> {
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Bitmap>?, isFirstResource: Boolean) =
                    when (callback) {
                        null -> {
                            false
                        }
                        else -> {
                            callback.onFail(e)
                            true
                        }
                    }

            override fun onResourceReady(resource: Bitmap?, model: Any?, target: Target<Bitmap>?, dataSource: DataSource?, isFirstResource: Boolean) =
                    when {
                        resource != null && callback != null -> {
                            img.setImageBitmap(resource)
                            callback.onSuccess()
                            true
                        }
                        else -> {
                            false
                        }

                    }

        }).into(img)
    }

}