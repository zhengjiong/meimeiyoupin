package com.meimeiyoupin.mvp.ui.activity

import android.os.Bundle
import android.support.v7.widget.Toolbar
import butterknife.BindView
import com.alibaba.android.arouter.facade.annotation.Route
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath

/**
 *
 * Copyright:Copyright(c) 2018
 * CreateTime:18/3/15$  14:59$
 * @author 郑炯
 * @version 1.0
 */
@Route(path = ARouterPath.UPLOAD_PICTURE)
class UploadPictureActivity : BaseActivity<IPresenter>() {
    @BindView(R.id.toolbar)
    lateinit var mToolbar: Toolbar

    override fun setupActivityComponent(appComponent: AppComponent) {

    }

    override fun initData(savedInstanceState: Bundle?) {
        mToolbar.setTitle(R.string.module_upload_picture_toolbar)
        mToolbar.setNavigationOnClickListener{
            finish()
        }
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.module_activity_upload_picture
    }

}