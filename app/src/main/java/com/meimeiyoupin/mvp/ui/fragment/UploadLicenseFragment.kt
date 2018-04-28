package com.meimeiyoupin.mvp.ui.fragment

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.bilibili.boxing.Boxing
import com.bilibili.boxing.model.config.BoxingConfig
import com.bilibili.boxing.model.entity.BaseMedia
import com.bilibili.boxing.model.entity.impl.ImageMedia
import com.bilibili.boxing_impl.ui.BoxingActivity
import com.blankj.utilcode.util.ConvertUtils
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.jakewharton.rxbinding2.view.RxView
import com.jess.arms.di.component.AppComponent
import com.jess.arms.http.imageloader.glide.GlideArms
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath
import com.meimeiyoupin.mvp.ui.base.BaseSupportFragment
import com.meimeiyoupin.utils.RequestCode
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.module_fragment_license_layout.*
import java.util.concurrent.TimeUnit

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/28$  09:22$
 * @author 郑炯
 * @version 1.0
 */

@Route(path = ARouterPath.UPLOAD_LICENSE)
class UploadLicenseFragment : BaseSupportFragment<IPresenter>() {

    companion object {

        @JvmStatic
        fun newInstance() = UploadLicenseFragment()
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun setData(data: Any?) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.module_fragment_license_layout, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {
        toolbar.title = "营业执照"
        toolbar.setNavigationOnClickListener {
            pop()
        }
        RxView.clicks(img1)
                .throttleFirst(300, TimeUnit.MILLISECONDS)
                .subscribe({
                    val boxing = Boxing.of(BoxingConfig(BoxingConfig.Mode.SINGLE_IMG).needCamera(R.mipmap.ic_boxing_camera_white))
                            .withIntent(activity, BoxingActivity::class.java)

                    /**
                     * 这里需要调用fragment的startActivityForResult方法, 不能使用boxing自带的start方法,
                     * 不然选择图片后不会进入fragment的onActivityResult方法
                     */
                    startActivityForResult(boxing.intent, RequestCode.REQUEST_CODE_BOXING)
                }, { }
                )
        RxView.clicks(btnNext)
                .throttleFirst(300, TimeUnit.MILLISECONDS)
                .subscribe(
                        {
                            start(UploadOfficePictureFragment.newInstance())
                        },
                        {
                        }
                )

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val medias: MutableList<BaseMedia>? = Boxing.getResult(data)
        medias ?: return
        if (medias.isEmpty()) {
            return
        }
        medias.forEach { baseMedia ->
            if (baseMedia is ImageMedia) {
                if (!baseMedia.path.isNullOrEmpty()) {
                    val path = baseMedia.path
                    GlideArms.with(context!!)
                            .asDrawable()
                            .load(path)
                            .centerCrop()
                            .transform(RoundedCorners(ConvertUtils.dp2px(6F)))
                            .into(object : SimpleTarget<Drawable>(500, 500) {
                                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                                    img1.setBackgroundDrawable(resource)
                                }

                            })
                    return@forEach
                }
            }

        }
    }
}