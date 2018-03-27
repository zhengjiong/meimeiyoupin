package com.meimeiyoupin.mvp.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.meimeiyoupin.R
import com.meimeiyoupin.app.ARouterPath

/**
 *
 * Copyright:Copyright(c) 2018
 * Company: 上加下信息技术成都有限公司
 * CreateTime:18/3/27$  04:35$
 * @author 郑炯
 * @version 1.0
 */
@Route(path = ARouterPath.INFORMATION_WRITE)
class InformationWriteActivity : BaseActivity<IPresenter>() {
    override fun setupActivityComponent(appComponent: AppComponent?) {

    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.module_activity_infomation_write_layout
    }

}