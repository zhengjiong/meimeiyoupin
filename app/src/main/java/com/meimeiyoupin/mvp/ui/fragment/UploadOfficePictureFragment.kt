package com.meimeiyoupin.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath
import com.meimeiyoupin.mvp.ui.base.BaseSupportFragment
import kotlinx.android.synthetic.main.module_fragment_upload_office_picture_layout.*

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/4/28$  09:42$
 * @author 郑炯
 * @version 1.0
 */

@Route(path = ARouterPath.UPLOAD_OFFICE_PICTURE)
class UploadOfficePictureFragment : BaseSupportFragment<IPresenter>() {

    companion object {
        fun newInstance() = UploadOfficePictureFragment()
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {

    }

    override fun setData(data: Any?) {

    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.module_fragment_upload_office_picture_layout, container, false)
    }

    override fun initData(savedInstanceState: Bundle?) {
        toolbar.title = "办公环境"
    }

}