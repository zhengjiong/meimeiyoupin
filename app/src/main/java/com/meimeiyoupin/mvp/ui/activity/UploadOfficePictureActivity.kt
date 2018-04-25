package com.meimeiyoupin.mvp.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath
import kotlinx.android.synthetic.main.module_activity_upload_office_picture_layout.*

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/3/27$  10:12$
 * @author 郑炯
 * @version 1.0
 */
@Route(path = ARouterPath.UPLOAD_OFFICE_PICTURE)
class UploadOfficePictureActivity : BaseActivity<IPresenter>() {

    override fun initData(savedInstanceState: Bundle?) {
        toolbar.title = "办公环境"
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.module_activity_upload_office_picture_layout
    }

    override fun setupActivityComponent(appComponent: AppComponent) {

    }

}