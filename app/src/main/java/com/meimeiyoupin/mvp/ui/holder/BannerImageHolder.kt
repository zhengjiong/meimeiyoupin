package com.meimeiyoupin.mvp.ui.holder

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bigkoo.convenientbanner.holder.Holder
import com.blankj.utilcode.util.ScreenUtils
import com.jess.arms.http.imageloader.glide.GlideArms
import com.meimeiyoupin.R

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/25$  14:07$
 * @author 郑炯
 * @version 1.0
 */


class BannerImageHolder(val bannerHeight: Int) : Holder<String> {
    lateinit var icon: AppCompatImageView
    override fun createView(context: Context?): View {
        icon = AppCompatImageView(context)
        icon.scaleType = ImageView.ScaleType.FIT_XY
        icon.layoutParams = ViewGroup.LayoutParams(ScreenUtils.getScreenWidth(), bannerHeight)
        icon.setBackgroundColor(context!!.resources.getColor(R.color.color_background))
        return icon
    }

    override fun UpdateUI(context: Context?, position: Int, data: String?) {
        GlideArms.with(context!!)
                .load("https://1919-new-bbc-test.oss-cn-beijing.aliyuncs.com/d394f3dd-3f64-4d0d-9f53-77304c8ad32f")
                .into(icon)
    }

}